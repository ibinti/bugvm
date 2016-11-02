#!/usr/bin/env bash
#./gradlew clean build dist dev env publishToMavenLocal copyIdea newMvn runMvn
./gradlew clean build copyIdea env publishToMavenLocal plugin-idea:idea
