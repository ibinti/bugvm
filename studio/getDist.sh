#!/bin/bash

version=$BUGVM_VERSION
rm -rf bugvm/bugvm-idea
mkdir bugvm/bugvm-idea
cd bugvm/bugvm-idea
wget https://github.com/bugvm/bugvm/releases/download/bugvm-$version/bugvm-idea-$version-plugin-dist.jar
cd ../..
