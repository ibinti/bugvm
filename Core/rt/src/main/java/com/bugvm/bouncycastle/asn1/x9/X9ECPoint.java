package com.bugvm.bouncycastle.asn1.x9;

import com.bugvm.bouncycastle.asn1.ASN1Object;
import com.bugvm.bouncycastle.asn1.ASN1OctetString;
import com.bugvm.bouncycastle.asn1.ASN1Primitive;
import com.bugvm.bouncycastle.asn1.DEROctetString;
import com.bugvm.bouncycastle.math.ec.ECCurve;
import com.bugvm.bouncycastle.math.ec.ECPoint;

/**
 * class for describing an ECPoint as a DER object.
 */
public class X9ECPoint
    extends ASN1Object
{
    ECPoint p;

    public X9ECPoint(
        ECPoint p)
    {
        this.p = p;
    }

    public X9ECPoint(
        ECCurve          c,
        ASN1OctetString  s)
    {
        this.p = c.decodePoint(s.getOctets());
    }

    public ECPoint getPoint()
    {
        return p;
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     *  ECPoint ::= OCTET STRING
     * </pre>
     * <p>
     * Octet string produced using ECPoint.getEncoded().
     */
    public ASN1Primitive toASN1Primitive()
    {
        return new DEROctetString(p.getEncoded());
    }
}
