/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.v2016_06_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ReplicationUsages.
 */
public class ReplicationUsagesInner {
    /** The Retrofit service to perform REST calls. */
    private ReplicationUsagesService service;
    /** The service client containing this operation class. */
    private RecoveryServicesClientImpl client;

    /**
     * Initializes an instance of ReplicationUsagesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ReplicationUsagesInner(Retrofit retrofit, RecoveryServicesClientImpl client) {
        this.service = retrofit.create(ReplicationUsagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ReplicationUsages to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ReplicationUsagesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.recoveryservices.v2016_06_01.ReplicationUsages list" })
        @GET("Subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.RecoveryServices/vaults/{vaultName}/replicationUsages")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("vaultName") String vaultName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Fetches the replication usages of the vault.
     *
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param vaultName The name of the recovery services vault.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;ReplicationUsageInner&gt; object if successful.
     */
    public List<ReplicationUsageInner> list(String resourceGroupName, String vaultName) {
        return listWithServiceResponseAsync(resourceGroupName, vaultName).toBlocking().single().body();
    }

    /**
     * Fetches the replication usages of the vault.
     *
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param vaultName The name of the recovery services vault.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ReplicationUsageInner>> listAsync(String resourceGroupName, String vaultName, final ServiceCallback<List<ReplicationUsageInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, vaultName), serviceCallback);
    }

    /**
     * Fetches the replication usages of the vault.
     *
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param vaultName The name of the recovery services vault.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ReplicationUsageInner&gt; object
     */
    public Observable<List<ReplicationUsageInner>> listAsync(String resourceGroupName, String vaultName) {
        return listWithServiceResponseAsync(resourceGroupName, vaultName).map(new Func1<ServiceResponse<List<ReplicationUsageInner>>, List<ReplicationUsageInner>>() {
            @Override
            public List<ReplicationUsageInner> call(ServiceResponse<List<ReplicationUsageInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Fetches the replication usages of the vault.
     *
     * @param resourceGroupName The name of the resource group where the recovery services vault is present.
     * @param vaultName The name of the recovery services vault.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ReplicationUsageInner&gt; object
     */
    public Observable<ServiceResponse<List<ReplicationUsageInner>>> listWithServiceResponseAsync(String resourceGroupName, String vaultName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (vaultName == null) {
            throw new IllegalArgumentException("Parameter vaultName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, vaultName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<ReplicationUsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<ReplicationUsageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ReplicationUsageInner>> result = listDelegate(response);
                        List<ReplicationUsageInner> items = null;
                        if (result.body() != null) {
                            items = result.body().items();
                        }
                        ServiceResponse<List<ReplicationUsageInner>> clientResponse = new ServiceResponse<List<ReplicationUsageInner>>(items, result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ReplicationUsageInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ReplicationUsageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ReplicationUsageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
