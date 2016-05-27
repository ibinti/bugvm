#!/bin/bash

ANDROID_PLUGIN_COMMIT=46f7904a9d8ce097136a942151724ffd51bfba12
ANDROID_TOOLS_BASE_COMMIT=4a46ed4b0524fc6389962de7fa3d79f69c6193a6
rm -rf android
git clone git://git.jetbrains.org/idea/android.git android
cd android
git pull
git checkout $ANDROID_PLUGIN_COMMIT
cd ..
git clone git://git.jetbrains.org/idea/adt-tools-base.git android/tools-base
cd android/tools-base
git pull
git checkout $ANDROID_TOOLS_BASE_COMMIT
cd ../..

version=$BUGVM_IDEA_PLUGIN_VERSION
rm -rf bugvm/bugvm-idea
mkdir bugvm/bugvm-idea
cd bugvm/bugvm-idea
wget https://github.com/bugvm/bugvm-idea/releases/download/bugvm-idea-$version/bugvm-idea-$version-plugin-dist.jar
cd ../..
