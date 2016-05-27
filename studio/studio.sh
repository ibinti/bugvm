#!/bin/bash
#./getPlugins.sh
set -e
: ${IDEA_HOME?"Need to set IDEA_HOME to point to a valid IntelliJ IDEA installation."}

version=$BUGVM_IDEA_PLUGIN_VERSION

## Build IntelliJ IDEA using our own build files
ant -f build-bugvm.xml
rm -rf out/bugvm-studio
mkdir -p out/bugvm-studio

## Copy the artifacts and build the DMG
cp out/artifacts/*.mac.zip out/bugvm-studio/bugvm-studio-$version.zip
cd out/bugvm-studio
unzip bugvm-studio-$version.zip
cd ../..
appdmg bugvm/bugvm-studio-dmg/dmg.json out/bugvm-studio/bugvm-studio-$version.dmg
