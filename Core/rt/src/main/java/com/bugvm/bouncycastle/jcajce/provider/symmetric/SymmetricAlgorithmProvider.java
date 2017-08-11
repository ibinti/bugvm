package com.bugvm.bouncycastle.jcajce.provider.symmetric;

import com.bugvm.bouncycastle.jcajce.provider.util.AlgorithmProvider;

abstract class SymmetricAlgorithmProvider
    extends AlgorithmProvider
{
    // BEGIN android-removed
    // protected void addGMacAlgorithm(
    //     ConfigurableProvider provider,
    //     String algorithm,
    //     String algorithmClassName,
    //     String keyGeneratorClassName)
    // {
    //     provider.addAlgorithm("Mac." + algorithm + "-GMAC", algorithmClassName);
    //     provider.addAlgorithm("Alg.Alias.Mac." + algorithm + "GMAC", algorithm + "-GMAC");
    //
    //     provider.addAlgorithm("KeyGenerator." + algorithm + "-GMAC", keyGeneratorClassName);
    //     provider.addAlgorithm("Alg.Alias.KeyGenerator." + algorithm + "GMAC",  algorithm + "-GMAC");
    // }
    // END android-removed
}
