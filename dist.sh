./gradlew clean build dist dev publishToMavenLocal
./gradlew copyIdea
cd plugin
mvn clean install
cd ..