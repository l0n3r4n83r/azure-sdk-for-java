/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Parameters supplied to the Create TagDescription operation.
 */
@JsonFlatten
public class TagDescriptionCreateParameters {
    /**
     * Description of the Tag.
     */
    @JsonProperty(value = "properties.description")
    private String description;

    /**
     * Absolute URL of external resources describing the tag.
     */
    @JsonProperty(value = "properties.externalDocsUrl")
    private String externalDocsUrl;

    /**
     * Description of the external resources describing the tag.
     */
    @JsonProperty(value = "properties.externalDocsDescription")
    private String externalDocsDescription;

    /**
     * Get description of the Tag.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set description of the Tag.
     *
     * @param description the description value to set
     * @return the TagDescriptionCreateParameters object itself.
     */
    public TagDescriptionCreateParameters withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get absolute URL of external resources describing the tag.
     *
     * @return the externalDocsUrl value
     */
    public String externalDocsUrl() {
        return this.externalDocsUrl;
    }

    /**
     * Set absolute URL of external resources describing the tag.
     *
     * @param externalDocsUrl the externalDocsUrl value to set
     * @return the TagDescriptionCreateParameters object itself.
     */
    public TagDescriptionCreateParameters withExternalDocsUrl(String externalDocsUrl) {
        this.externalDocsUrl = externalDocsUrl;
        return this;
    }

    /**
     * Get description of the external resources describing the tag.
     *
     * @return the externalDocsDescription value
     */
    public String externalDocsDescription() {
        return this.externalDocsDescription;
    }

    /**
     * Set description of the external resources describing the tag.
     *
     * @param externalDocsDescription the externalDocsDescription value to set
     * @return the TagDescriptionCreateParameters object itself.
     */
    public TagDescriptionCreateParameters withExternalDocsDescription(String externalDocsDescription) {
        this.externalDocsDescription = externalDocsDescription;
        return this;
    }

}
