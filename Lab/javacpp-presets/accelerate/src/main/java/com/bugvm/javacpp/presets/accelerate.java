package com.bugvm.javacpp.presets;

import com.bugvm.javacpp.annotation.*;
import com.bugvm.javacpp.tools.*;

@Properties(target="com.bugvm.javacpp.accelerate", value={@Platform(include={"cblas.h","clapack.h"},
        includepath = {"/System/Library/Frameworks/Accelerate.framework/Frameworks/vecLib.framework/Headers/"},
        preload = {"BLAS","LAPACK"},
        preloadpath = {"/System/Library/Frameworks/Accelerate.framework/Frameworks/vecLib.framework/vecLib/"})})
public class accelerate implements InfoMapper {
    public void map(InfoMap infoMap) {
        infoMap.put(new Info("CBLAS_INDEX").cppTypes().annotations());
    }
}