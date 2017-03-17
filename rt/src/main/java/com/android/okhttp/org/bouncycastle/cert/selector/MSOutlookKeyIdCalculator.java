package com.android.org.bouncycastle.cert.selector;

import java.io.IOException;

import com.android.org.bouncycastle.asn1.ASN1Encoding;
import com.android.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.android.org.bouncycastle.crypto.Digest;
import com.android.org.bouncycastle.crypto.digests.SHA1Digest;

class MSOutlookKeyIdCalculator
{
    static byte[] calculateKeyId(SubjectPublicKeyInfo info)
    {
        Digest dig = new SHA1Digest();    // TODO: include definition of SHA-1 here
        byte[] hash = new byte[dig.getDigestSize()];
        byte[] spkiEnc = new byte[0];
        try
        {
            spkiEnc = info.getEncoded(ASN1Encoding.DER);
        }
        catch (IOException e)
        {
            return new byte[0];
        }

        // try the outlook 2010 calculation
        dig.update(spkiEnc, 0, spkiEnc.length);

        dig.doFinal(hash, 0);

        return hash;
    }
}
