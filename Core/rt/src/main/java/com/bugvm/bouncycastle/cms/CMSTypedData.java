package com.bugvm.bouncycastle.cms;

import com.bugvm.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface CMSTypedData
    extends CMSProcessable
{
    ASN1ObjectIdentifier getContentType();
}
