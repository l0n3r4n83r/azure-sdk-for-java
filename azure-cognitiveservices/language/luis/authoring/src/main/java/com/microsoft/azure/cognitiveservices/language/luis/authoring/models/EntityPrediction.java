/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A suggested entity.
 */
public class EntityPrediction {
    /**
     * The entity's name.
     */
    @JsonProperty(value = "entityName", required = true)
    private String entityName;

    /**
     * The index within the utterance where the extracted entity starts.
     */
    @JsonProperty(value = "startTokenIndex", required = true)
    private int startTokenIndex;

    /**
     * The index within the utterance where the extracted entity ends.
     */
    @JsonProperty(value = "endTokenIndex", required = true)
    private int endTokenIndex;

    /**
     * The actual token(s) that comprise the entity.
     */
    @JsonProperty(value = "phrase", required = true)
    private String phrase;

    /**
     * Get the entityName value.
     *
     * @return the entityName value
     */
    public String entityName() {
        return this.entityName;
    }

    /**
     * Set the entityName value.
     *
     * @param entityName the entityName value to set
     * @return the EntityPrediction object itself.
     */
    public EntityPrediction withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    /**
     * Get the startTokenIndex value.
     *
     * @return the startTokenIndex value
     */
    public int startTokenIndex() {
        return this.startTokenIndex;
    }

    /**
     * Set the startTokenIndex value.
     *
     * @param startTokenIndex the startTokenIndex value to set
     * @return the EntityPrediction object itself.
     */
    public EntityPrediction withStartTokenIndex(int startTokenIndex) {
        this.startTokenIndex = startTokenIndex;
        return this;
    }

    /**
     * Get the endTokenIndex value.
     *
     * @return the endTokenIndex value
     */
    public int endTokenIndex() {
        return this.endTokenIndex;
    }

    /**
     * Set the endTokenIndex value.
     *
     * @param endTokenIndex the endTokenIndex value to set
     * @return the EntityPrediction object itself.
     */
    public EntityPrediction withEndTokenIndex(int endTokenIndex) {
        this.endTokenIndex = endTokenIndex;
        return this;
    }

    /**
     * Get the phrase value.
     *
     * @return the phrase value
     */
    public String phrase() {
        return this.phrase;
    }

    /**
     * Set the phrase value.
     *
     * @param phrase the phrase value to set
     * @return the EntityPrediction object itself.
     */
    public EntityPrediction withPhrase(String phrase) {
        this.phrase = phrase;
        return this;
    }

}