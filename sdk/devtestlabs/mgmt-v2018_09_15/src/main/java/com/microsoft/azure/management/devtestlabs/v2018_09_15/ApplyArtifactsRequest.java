/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body for applying artifacts to a virtual machine.
 */
public class ApplyArtifactsRequest {
    /**
     * The list of artifacts to apply.
     */
    @JsonProperty(value = "artifacts")
    private List<ArtifactInstallProperties> artifacts;

    /**
     * Get the list of artifacts to apply.
     *
     * @return the artifacts value
     */
    public List<ArtifactInstallProperties> artifacts() {
        return this.artifacts;
    }

    /**
     * Set the list of artifacts to apply.
     *
     * @param artifacts the artifacts value to set
     * @return the ApplyArtifactsRequest object itself.
     */
    public ApplyArtifactsRequest withArtifacts(List<ArtifactInstallProperties> artifacts) {
        this.artifacts = artifacts;
        return this;
    }

}
