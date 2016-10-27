
cd ../soot
./gradlew build
cd ../rt
./gradlew build
cd ../llvm
./gradlew build
cd ../compiler
./gradlew build
cd ../cacerts
./gradlew build
cd ../apple
./gradlew build
cd ../package
./gradlew dist
