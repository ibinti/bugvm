package com.bugvm.bouncycastle.operator.bc;

import com.bugvm.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.bugvm.bouncycastle.crypto.ExtendedDigest;
import com.bugvm.bouncycastle.operator.OperatorCreationException;

public interface BcDigestProvider
{
    ExtendedDigest get(AlgorithmIdentifier digestAlgorithmIdentifier)
        throws OperatorCreationException;
}
