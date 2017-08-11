package com.bugvm.bouncycastle.cert.selector;

import java.io.IOException;

import com.bugvm.bouncycastle.asn1.ASN1Encoding;
import com.bugvm.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import com.bugvm.bouncycastle.crypto.Digest;
import com.bugvm.bouncycastle.crypto.digests.SHA1Digest;

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
