#!/bin/bash
mvn install -P release
cd gradle
./gradlew clean build install
cd .. 
