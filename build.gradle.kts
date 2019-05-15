buildscript {
    ext {
        bugvm_version = "1.3.0-SNAPSHOT"
        kotlin_version = "1.3.31"
    }
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("com.bmuschko:gradle-nexus-plugin:2.3.1")
        classpath("io.codearte.gradle.nexus:gradle-nexus-staging-plugin:0.7.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath("com.github.jengelman.gradle.plugins:shadow:4.0.2")
    }
}

allprojects {

    group = "com.bugvm"
    version = bugvm_version

    apply plugin: "kotlin"

    sourceCompatibility = 1.8
    targetCompatibility = 1.8

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    javadoc {
        exclude "**"
    }

    repositories {
        mavenLocal()
        maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
        mavenCentral()
    }

    dependencies {
        implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    }

}

apply plugin: "maven"
apply plugin: "signing"
apply plugin: "com.bmuschko.nexus"
apply plugin: "io.codearte.nexus-staging"

defaultTasks "install"

task jars {
    dependsOn install, build, clean
    install.mustRunAfter build
    build.mustRunAfter clean
}

task rt {
    dependsOn ":core:rt:native_lib"
}

task rt_clean {
    dependsOn ":core:rt:native_lib_clean"
}

task llvm {
    dependsOn ":core:llvm:native_lib"
}

task all  {
    dependsOn jars, rt_clean, llvm
    jars.mustRunAfter llvm
    llvm.mustRunAfter rt_clean
}

archivesBaseName = "bugvm-dist"
description = "bugvm dist package (tgz)"

dependencies {
    compile project(":core:compiler")
    compile project(":binding:apple")
    compile project(":core:rt")
}

task tgzTask(type: Tar) {

    extension = "tgz"
    compression = Compression.GZIP

    into ("bugvm-${version}/bin") {
        from ("Core/bin")
    }

    into("bugvm-${version}/lib") {
        from  "core/compiler/build/libs/bugvm-compiler-${version}.jar" rename { String fileName -> fileName.replace("bugvm-compiler-${version}.jar", "bugvm-compiler.jar") }
        from("core/rt/build/libs/bugvm-rt-${version}.jar") rename { String fileName -> fileName.replace("bugvm-rt-${version}.jar", "bugvm-rt.jar") }
        from("binding/apple/build/libs/bugvm-apple-${version}.jar") rename { String fileName -> fileName.replace("bugvm-apple-${version}.jar", "bugvm-apple.jar") }
    }

    into ("bugvm-${version}/lib/vm") {
        from ("core/rt/vm/binaries")
    }

    into ("bugvm-${version}/modules/licenses/apple") {
        from ("binding/apple/NOTICE.txt")
        from ("binding/apple/LICENSE.txt")
    }

    into ("bugvm-${version}/modules/licenses/llvm") {
        from ("core/llvm/NOTICE.txt")
        from ("core/llvm/LICENSE.txt")
    }

    into ("bugvm-${version}/modules/licenses/rt") {
        from ("core/rt/NOTICE.txt")
        from ("core/rt/LICENSE.txt")
    }

    into ("bugvm-${version}/modules/licenses/compiler") {
        from ("core/compiler/NOTICE.txt")
        from ("core/compiler/LICENSE.txt")
    }

    into ("bugvm-${version}/modules/licenses/vm") {
        from ("core/vm/NOTICE.txt")
        from ("core/vm/LICENSE.txt")
    }

    outputs.upToDateWhen { false }
}

artifacts {
    archives tgzTask
}

modifyPom {
    project {
        name project.archivesBaseName
        description project.description
        licenses {
            license {
                name "gnu general public license, version 2"
                url "https://www.gnu.org/licenses/gpl-2.0.html"
                distribution "repo"
            }
        }
        url "https://ibinti.com/bugvm"

        scm {
            url "https://github.com/ibinti/bugvm"
            connection "scm:git:git://github.com/ibinti/bugvm.git"
            developerConnection "scm:git:ssh://github.com:ibinti/bugvm.git"
        }

        developers {
            developer {
                id "bugvm"
                name "bugvm"
                email "bugvm@ibinti.com"
                organization "ibinti.com"
                organizationUrl "https://ibinti.com"
            }
        }
    }
}

/* gradle upgrade instructions

./gradlew wrapper --gradle-version 5.4.1 --distribution-type all

note: "com.github.jengelman.gradle.plugins:shadow:4.0.2" requires gradle 4.*
gradle upgrade hold until this issue resolves

*/