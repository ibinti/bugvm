package com.bugvm.bouncycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

import com.bugvm.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.bugvm.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import com.bugvm.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import com.bugvm.bouncycastle.crypto.params.AsymmetricKeyParameter;
import com.bugvm.bouncycastle.crypto.params.DSAParameters;
import com.bugvm.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import com.bugvm.bouncycastle.crypto.params.DSAPublicKeyParameters;

/**
 * utility class for converting jce/jca DSA objects
 * objects into their com.bugvm.bouncycastle.crypto counterparts.
 */
public class DSAUtil
{
    public static final ASN1ObjectIdentifier[] dsaOids =
    {
        X9ObjectIdentifiers.id_dsa,
        OIWObjectIdentifiers.dsaWithSHA1
    };

    public static boolean isDsaOid(
        ASN1ObjectIdentifier algOid)
    {
        for (int i = 0; i != dsaOids.length; i++)
        {
            if (algOid.equals(dsaOids[i]))
            {
                return true;
            }
        }

        return false;
    }

    static public AsymmetricKeyParameter generatePublicKeyParameter(
        PublicKey    key)
        throws InvalidKeyException
    {
        if (key instanceof DSAPublicKey)
        {
            DSAPublicKey    k = (DSAPublicKey)key;

            return new DSAPublicKeyParameters(k.getY(),
                new DSAParameters(k.getParams().getP(), k.getParams().getQ(), k.getParams().getG()));
        }

        throw new InvalidKeyException("can't identify DSA public key: " + key.getClass().getName());
    }

    static public AsymmetricKeyParameter generatePrivateKeyParameter(
        PrivateKey    key)
        throws InvalidKeyException
    {
        if (key instanceof DSAPrivateKey)
        {
            DSAPrivateKey    k = (DSAPrivateKey)key;

            return new DSAPrivateKeyParameters(k.getX(),
                new DSAParameters(k.getParams().getP(), k.getParams().getQ(), k.getParams().getG()));
        }
                        
        throw new InvalidKeyException("can't identify DSA private key.");
    }
}
