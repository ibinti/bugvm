/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package org.javafxports.jfxmobile.plugin.android.task

import com.google.common.base.Charsets
import com.google.common.io.Files
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.android.JFXMobileDexOptions
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

class CreateManifestKeepList extends DefaultTask {

    @Nested
    JFXMobileDexOptions dexOptions

    @InputFile
    File manifest

    @OutputFile
    File outputFile

    @InputFile @Optional
    File proguardFile

    Closure filter

    @TaskAction
    void generateKeepListFromManifest() {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser()

        Writer out = new BufferedWriter(new FileWriter(getOutputFile()))
        try {
            parser.parse(getManifest(), new ManifestHandler(out))

            // add a couple of rules that cannot be easily parsed from the manifest.
            out.write(
"""-keep public class * extends android.app.backup.BackupAgent {
    <init>();
}
-keep public class * extends java.lang.annotation.Annotation {
    *;
}
""")

            if (!getDexOptions().keepRuntimeAnnotatedClasses) {
                out.write("-keep class ${project.mainClassName} { <init>(); }")
            }

            if (getProguardFile() != null) {
                out.write('\n')
                out.write(Files.toString(getProguardFile(), Charsets.UTF_8))
            }
        } finally {
            out.close()
        }
    }

    private static String DEFAULT_KEEP_SPEC = "{ <init>(); }"
    private static Map<String, String> KEEP_SPECS = [
        'application'       : """{
    <init>();
    void attachBaseContext(android.content.Context);
}""",
        'activity'          : DEFAULT_KEEP_SPEC,
        'service'           : DEFAULT_KEEP_SPEC,
        'receiver'          : DEFAULT_KEEP_SPEC,
        'provider'          : DEFAULT_KEEP_SPEC,
        'instrumentation'   : DEFAULT_KEEP_SPEC,
    ]

    private class ManifestHandler extends DefaultHandler {
        private Writer out

        ManifestHandler(Writer out) {
            this.out = out
        }

        @Override
        void startElement(String uri, String localName, String qName, Attributes attr) {
            String keepSpec = (String)CreateManifestKeepList.KEEP_SPECS[qName]
            if (keepSpec) {

                boolean keepIt = true
                if (CreateManifestKeepList.this.filter) {
                    // for ease of use, turn 'attr' into a simple map
                    Map<String, String> attrMap = [:]
                    for (int i = 0; i < attr.getLength(); i++) {
                        attrMap[attr.getQName(i)] = attr.getValue(i)
                    }
                    keepIt = CreateManifestKeepList.this.filter(qName, attrMap)
                }

                if (keepIt) {
                    out.write((String)"-keep class ${attr.getValue('android:name')} $keepSpec\n")
                }
            }
        }
    }
}
