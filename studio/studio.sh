#!/bin/bash
#./getAndroid.sh
set -e
: ${IDEA_HOME?"Need to set IDEA_HOME to point to a valid BugVM Studio installation."}

## Build BugVM Studio using our own build files
ant -f build-bugvm.xml
rm -rf out/bugvm-studio
mkdir -p out/bugvm-studio

## Copy the artifacts and build the DMG
cp out/artifacts/*.mac.zip out/bugvm-studio/bugvm-studio.zip
cd out/bugvm-studio
unzip bugvm-studio.zip
cd ../..
appdmg bugvm/bugvm-studio-dmg/dmg.json out/bugvm-studio/bugvm-studio-1.1.6.dmg