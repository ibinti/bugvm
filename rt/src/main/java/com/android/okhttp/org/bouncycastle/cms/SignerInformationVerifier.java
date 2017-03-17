package com.android.org.bouncycastle.cms;

import com.android.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.org.bouncycastle.cert.X509CertificateHolder;
import com.android.org.bouncycastle.operator.ContentVerifier;
import com.android.org.bouncycastle.operator.ContentVerifierProvider;
import com.android.org.bouncycastle.operator.DigestCalculator;
import com.android.org.bouncycastle.operator.DigestCalculatorProvider;
import com.android.org.bouncycastle.operator.OperatorCreationException;
import com.android.org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;

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
