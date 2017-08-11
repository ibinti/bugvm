package com.bugvm.bouncycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;

import com.bugvm.bouncycastle.jce.spec.ECParameterSpec;

public interface ProviderConfiguration
{
    ECParameterSpec getEcImplicitlyCa();

    DHParameterSpec getDHDefaultParameters(int keySize);
}
