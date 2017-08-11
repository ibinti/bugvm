package com.bugvm.bouncycastle.cms.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

import com.bugvm.bouncycastle.cert.X509CertificateHolder;
import com.bugvm.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import com.bugvm.bouncycastle.cms.CMSAttributeTableGenerator;
import com.bugvm.bouncycastle.cms.SignerInfoGenerator;
import com.bugvm.bouncycastle.cms.SignerInfoGeneratorBuilder;
import com.bugvm.bouncycastle.operator.ContentSigner;
import com.bugvm.bouncycastle.operator.DigestCalculatorProvider;
import com.bugvm.bouncycastle.operator.OperatorCreationException;

public class JcaSignerInfoGeneratorBuilder
{
    private SignerInfoGeneratorBuilder builder;

    public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider digestProvider)
    {
        builder = new SignerInfoGeneratorBuilder(digestProvider);
    }

    /**
     * If the passed in flag is true, the signer signature will be based on the data, not
     * a collection of signed attributes, and no signed attributes will be included.
     *
     * @return the builder object
     */
    public JcaSignerInfoGeneratorBuilder setDirectSignature(boolean hasNoSignedAttributes)
    {
        builder.setDirectSignature(hasNoSignedAttributes);

        return this;
    }

    public JcaSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator signedGen)
    {
        builder.setSignedAttributeGenerator(signedGen);

        return this;
    }

    public JcaSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator unsignedGen)
    {
        builder.setUnsignedAttributeGenerator(unsignedGen);

        return this;
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, X509CertificateHolder certHolder)
        throws OperatorCreationException
    {
        return builder.build(contentSigner, certHolder);
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, byte[] keyIdentifier)
        throws OperatorCreationException
    {
        return builder.build(contentSigner, keyIdentifier);
    }

    public SignerInfoGenerator build(ContentSigner contentSigner, X509Certificate certificate)
        throws OperatorCreationException, CertificateEncodingException
    {
        return this.build(contentSigner, new JcaX509CertificateHolder(certificate));
    }
}
