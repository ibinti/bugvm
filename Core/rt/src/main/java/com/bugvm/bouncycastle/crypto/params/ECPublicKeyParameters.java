package com.bugvm.bouncycastle.crypto.params;

import com.bugvm.bouncycastle.math.ec.ECPoint;

public class ECPublicKeyParameters
    extends ECKeyParameters
{
    ECPoint Q;

    public ECPublicKeyParameters(
        ECPoint             Q,
        ECDomainParameters  params)
    {
        super(false, params);
        this.Q = Q;
    }

    public ECPoint getQ()
    {
        return Q;
    }
}
