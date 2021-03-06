/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.timeseriesinsights.v2017_11_15;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An object that represents the status of the environment, and its internal
 * state in the Time Series Insights service.
 */
public class EnvironmentStatus {
    /**
     * An object that represents the status of ingress on an environment.
     */
    @JsonProperty(value = "ingress")
    private IngressEnvironmentStatus ingress;

    /**
     * Get an object that represents the status of ingress on an environment.
     *
     * @return the ingress value
     */
    public IngressEnvironmentStatus ingress() {
        return this.ingress;
    }

    /**
     * Set an object that represents the status of ingress on an environment.
     *
     * @param ingress the ingress value to set
     * @return the EnvironmentStatus object itself.
     */
    public EnvironmentStatus withIngress(IngressEnvironmentStatus ingress) {
        this.ingress = ingress;
        return this;
    }

}
