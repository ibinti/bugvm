package com.bugvm.bouncycastle.jcajce.provider.util;

import com.bugvm.bouncycastle.jcajce.provider.config.ConfigurableProvider;

public abstract class AlgorithmProvider
{
    public abstract void configure(ConfigurableProvider provider);
}
