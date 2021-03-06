/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.machinelearningservices.v2019_05_01.implementation;

import com.microsoft.azure.management.machinelearningservices.v2019_05_01.Compute;
import com.microsoft.azure.management.machinelearningservices.v2019_05_01.Identity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * Machine Learning compute object wrapped into ARM resource envelope.
 */
@SkipParentValidation
public class ComputeResourceInner extends Resource {
    /**
     * Compute properties.
     */
    @JsonProperty(value = "properties")
    private Compute properties;

    /**
     * The identity of the resource.
     */
    @JsonProperty(value = "identity", access = JsonProperty.Access.WRITE_ONLY)
    private Identity identity;

    /**
     * Get compute properties.
     *
     * @return the properties value
     */
    public Compute properties() {
        return this.properties;
    }

    /**
     * Set compute properties.
     *
     * @param properties the properties value to set
     * @return the ComputeResourceInner object itself.
     */
    public ComputeResourceInner withProperties(Compute properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the identity of the resource.
     *
     * @return the identity value
     */
    public Identity identity() {
        return this.identity;
    }

}
