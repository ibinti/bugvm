package com.bugvm.bouncycastle.jcajce.provider.symmetric.util;

import com.bugvm.bouncycastle.crypto.BlockCipher;

public interface BlockCipherProvider
{
    BlockCipher get();
}
