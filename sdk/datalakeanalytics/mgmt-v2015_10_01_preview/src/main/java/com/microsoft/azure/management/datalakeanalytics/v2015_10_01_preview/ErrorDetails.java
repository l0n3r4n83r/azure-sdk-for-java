/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakeanalytics.v2015_10_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Generic resource error details information.
 */
public class ErrorDetails {
    /**
     * the HTTP status code or error code associated with this error.
     */
    @JsonProperty(value = "code", access = JsonProperty.Access.WRITE_ONLY)
    private String code;

    /**
     * the error message localized based on Accept-Language.
     */
    @JsonProperty(value = "message", access = JsonProperty.Access.WRITE_ONLY)
    private String message;

    /**
     * the target of the particular error (for example, the name of the
     * property in error).
     */
    @JsonProperty(value = "target", access = JsonProperty.Access.WRITE_ONLY)
    private String target;

    /**
     * Get the HTTP status code or error code associated with this error.
     *
     * @return the code value
     */
    public String code() {
        return this.code;
    }

    /**
     * Get the error message localized based on Accept-Language.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Get the target of the particular error (for example, the name of the property in error).
     *
     * @return the target value
     */
    public String target() {
        return this.target;
    }

}
