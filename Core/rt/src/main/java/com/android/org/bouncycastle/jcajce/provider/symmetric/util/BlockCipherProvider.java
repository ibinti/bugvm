package com.android.org.bouncycastle.jcajce.provider.symmetric.util;

import com.android.org.bouncycastle.crypto.BlockCipher;

public interface BlockCipherProvider
{
    BlockCipher get();
}
