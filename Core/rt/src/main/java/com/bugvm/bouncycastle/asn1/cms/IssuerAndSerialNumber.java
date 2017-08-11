package com.bugvm.bouncycastle.asn1.cms;

import java.math.BigInteger;

import com.bugvm.bouncycastle.asn1.ASN1EncodableVector;
import com.bugvm.bouncycastle.asn1.ASN1Integer;
import com.bugvm.bouncycastle.asn1.ASN1Object;
import com.bugvm.bouncycastle.asn1.ASN1Primitive;
import com.bugvm.bouncycastle.asn1.ASN1Sequence;
import com.bugvm.bouncycastle.asn1.DERSequence;
import com.bugvm.bouncycastle.asn1.x500.X500Name;
import com.bugvm.bouncycastle.asn1.x509.Certificate;
import com.bugvm.bouncycastle.asn1.x509.X509CertificateStructure;
import com.bugvm.bouncycastle.asn1.x509.X509Name;

public class IssuerAndSerialNumber
    extends ASN1Object
{
    private X500Name    name;
    private ASN1Integer  serialNumber;

    public static IssuerAndSerialNumber getInstance(
        Object  obj)
    {
        if (obj instanceof IssuerAndSerialNumber)
        {
            return (IssuerAndSerialNumber)obj;
        }
        else if (obj != null)
        {
            return new IssuerAndSerialNumber(ASN1Sequence.getInstance(obj));
        }

        return null;
    }

    /**
     * @deprecated  use getInstance() method.
     * @param seq
     */
    public IssuerAndSerialNumber(
        ASN1Sequence    seq)
    {
        this.name = X500Name.getInstance(seq.getObjectAt(0));
        this.serialNumber = (ASN1Integer)seq.getObjectAt(1);
    }

    public IssuerAndSerialNumber(
        Certificate certificate)
    {
        this.name = certificate.getIssuer();
        this.serialNumber = certificate.getSerialNumber();
    }

    public IssuerAndSerialNumber(
        X509CertificateStructure certificate)
    {
        this.name = certificate.getIssuer();
        this.serialNumber = certificate.getSerialNumber();
    }

    public IssuerAndSerialNumber(
        X500Name name,
        BigInteger  serialNumber)
    {
        this.name = name;
        this.serialNumber = new ASN1Integer(serialNumber);
    }

    /**
     * @deprecated use X500Name constructor
     */
    public IssuerAndSerialNumber(
        X509Name    name,
        BigInteger  serialNumber)
    {
        this.name = X500Name.getInstance(name);
        this.serialNumber = new ASN1Integer(serialNumber);
    }

    /**
     * @deprecated use X500Name constructor
     */
    public IssuerAndSerialNumber(
        X509Name    name,
        ASN1Integer  serialNumber)
    {
        this.name = X500Name.getInstance(name);
        this.serialNumber = serialNumber;
    }

    public X500Name getName()
    {
        return name;
    }

    public ASN1Integer getSerialNumber()
    {
        return serialNumber;
    }

    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector    v = new ASN1EncodableVector();

        v.add(name);
        v.add(serialNumber);

        return new DERSequence(v);
    }
}
