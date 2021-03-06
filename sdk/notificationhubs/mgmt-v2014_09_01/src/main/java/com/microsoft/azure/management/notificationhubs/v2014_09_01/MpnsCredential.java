/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.notificationhubs.v2014_09_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Description of a NotificationHub MpnsCredential.
 */
public class MpnsCredential {
    /**
     * Gets or sets properties of NotificationHub MpnsCredential.
     */
    @JsonProperty(value = "properties")
    private MpnsCredentialProperties properties;

    /**
     * Get gets or sets properties of NotificationHub MpnsCredential.
     *
     * @return the properties value
     */
    public MpnsCredentialProperties properties() {
        return this.properties;
    }

    /**
     * Set gets or sets properties of NotificationHub MpnsCredential.
     *
     * @param properties the properties value to set
     * @return the MpnsCredential object itself.
     */
    public MpnsCredential withProperties(MpnsCredentialProperties properties) {
        this.properties = properties;
        return this;
    }

}
