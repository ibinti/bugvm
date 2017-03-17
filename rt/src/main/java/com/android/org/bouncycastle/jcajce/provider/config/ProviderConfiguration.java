package com.android.org.bouncycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;

import com.android.org.bouncycastle.jce.spec.ECParameterSpec;

public interface ProviderConfiguration
{
    ECParameterSpec getEcImplicitlyCa();

    DHParameterSpec getDHDefaultParameters(int keySize);
}
