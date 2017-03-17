package com.android.org.bouncycastle.cms;

import com.android.org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface CMSTypedData
    extends CMSProcessable
{
    ASN1ObjectIdentifier getContentType();
}
