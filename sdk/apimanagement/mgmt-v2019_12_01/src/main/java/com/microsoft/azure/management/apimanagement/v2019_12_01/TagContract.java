/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.apimanagement.v2019_12_01.implementation.TagContractInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.apimanagement.v2019_12_01.implementation.ApiManagementManager;

/**
 * Type representing TagContract.
 */
public interface TagContract extends HasInner<TagContractInner>, Indexable, Refreshable<TagContract>, Updatable<TagContract.Update>, HasManager<ApiManagementManager> {
    /**
     * @return the displayName value.
     */
    String displayName();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the TagContract definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithOperation, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of TagContract definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a TagContract definition.
         */
        interface Blank extends WithOperation {
        }

        /**
         * The stage of the tagcontract definition allowing to specify Operation.
         */
        interface WithOperation {
           /**
            * Specifies resourceGroupName, serviceName, apiId, operationId.
            * @param resourceGroupName The name of the resource group
            * @param serviceName The name of the API Management service
            * @param apiId API revision identifier. Must be unique in the current API Management service instance. Non-current revision has ;rev=n as a suffix where n is the revision number
            * @param operationId Operation identifier within an API. Must be unique in the current API Management service instance
            * @return the next definition stage
            */
            WithCreate withExistingOperation(String resourceGroupName, String serviceName, String apiId, String operationId);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<TagContract> {
        }
    }
    /**
     * The template for a TagContract update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<TagContract> {
    }

    /**
     * Grouping of TagContract update stages.
     */
    interface UpdateStages {
    }
}
