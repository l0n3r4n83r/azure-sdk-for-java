// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.keyvault.cryptography;

public abstract class AsymmetricSignatureAlgorithm extends SignatureAlgorithm {

    protected AsymmetricSignatureAlgorithm(String name) {
        super(name);
    }

}
