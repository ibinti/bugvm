package com.bugvm.bouncycastle.cms;

import com.bugvm.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.bugvm.bouncycastle.cert.X509CertificateHolder;
import com.bugvm.bouncycastle.operator.ContentVerifier;
import com.bugvm.bouncycastle.operator.ContentVerifierProvider;
import com.bugvm.bouncycastle.operator.DigestCalculator;
import com.bugvm.bouncycastle.operator.DigestCalculatorProvider;
import com.bugvm.bouncycastle.operator.OperatorCreationException;
import com.bugvm.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;

public class SignerInformationVerifier
{
    private ContentVerifierProvider verifierProvider;
    private DigestCalculatorProvider digestProvider;
    private SignatureAlgorithmIdentifierFinder sigAlgorithmFinder;
    private CMSSignatureAlgorithmNameGenerator sigNameGenerator;

    public SignerInformationVerifier(CMSSignatureAlgorithmNameGenerator sigNameGenerator, SignatureAlgorithmIdentifierFinder sigAlgorithmFinder, ContentVerifierProvider verifierProvider, DigestCalculatorProvider digestProvider)
    {
        this.sigNameGenerator = sigNameGenerator;
        this.sigAlgorithmFinder = sigAlgorithmFinder;
        this.verifierProvider = verifierProvider;
        this.digestProvider = digestProvider;
    }

    public boolean hasAssociatedCertificate()
    {
        return verifierProvider.hasAssociatedCertificate();
    }

    public X509CertificateHolder getAssociatedCertificate()
    {
        return verifierProvider.getAssociatedCertificate();
    }

    public ContentVerifier getContentVerifier(AlgorithmIdentifier signingAlgorithm, AlgorithmIdentifier digestAlgorithm)
        throws OperatorCreationException
    {
        String          signatureName = sigNameGenerator.getSignatureName(digestAlgorithm, signingAlgorithm);

        return verifierProvider.get(sigAlgorithmFinder.find(signatureName));
    }

    public DigestCalculator getDigestCalculator(AlgorithmIdentifier algorithmIdentifier)
        throws OperatorCreationException
    {
        return digestProvider.get(algorithmIdentifier);
    }
}
