package com.bugvm.bouncycastle.jcajce.provider.keystore;

import com.bugvm.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import com.bugvm.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class BC
{
    private static final String PREFIX = "com.bugvm.bouncycastle.jcajce.provider.keystore" + ".bc.";

    public static class Mappings
        extends AsymmetricAlgorithmProvider
    {
        public Mappings()
        {
        }

        public void configure(ConfigurableProvider provider)
        {
            provider.addAlgorithm("KeyStore.BKS", PREFIX + "BcKeyStoreSpi$Std");
            // BEGIN android-removed
            // provider.addAlgorithm("KeyStore.BKS-V1", PREFIX + "BcKeyStoreSpi$Version1");
            // END android-removed
            provider.addAlgorithm("KeyStore.BouncyCastle", PREFIX + "BcKeyStoreSpi$BouncyCastleStore");
            provider.addAlgorithm("Alg.Alias.KeyStore.UBER", "BouncyCastle");
            provider.addAlgorithm("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
            provider.addAlgorithm("Alg.Alias.KeyStore.bouncycastle", "BouncyCastle");
        }
    }
}
