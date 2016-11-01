#!/usr/bin/env bash
./gradlew clean build dist dev env publishToMavenLocal copyIdea newMvn runMvn
