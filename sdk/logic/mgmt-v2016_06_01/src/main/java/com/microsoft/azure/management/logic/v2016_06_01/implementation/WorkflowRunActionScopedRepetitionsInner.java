/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2016_06_01.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
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
 * in WorkflowRunActionScopedRepetitions.
 */
public class WorkflowRunActionScopedRepetitionsInner {
    /** The Retrofit service to perform REST calls. */
    private WorkflowRunActionScopedRepetitionsService service;
    /** The service client containing this operation class. */
    private LogicManagementClientImpl client;

    /**
     * Initializes an instance of WorkflowRunActionScopedRepetitionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public WorkflowRunActionScopedRepetitionsInner(Retrofit retrofit, LogicManagementClientImpl client) {
        this.service = retrofit.create(WorkflowRunActionScopedRepetitionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for WorkflowRunActionScopedRepetitions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface WorkflowRunActionScopedRepetitionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.logic.v2016_06_01.WorkflowRunActionScopedRepetitions list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Logic/workflows/{workflowName}/runs/{runName}/actions/{actionName}/scopeRepetitions")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("workflowName") String workflowName, @Path("runName") String runName, @Path("actionName") String actionName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.logic.v2016_06_01.WorkflowRunActionScopedRepetitions get" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Logic/workflows/{workflowName}/runs/{runName}/actions/{actionName}/scopeRepetitions/{repetitionName}")
        Observable<Response<ResponseBody>> get(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("workflowName") String workflowName, @Path("runName") String runName, @Path("actionName") String actionName, @Path("repetitionName") String repetitionName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * List the workflow run action scoped repetitions.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the WorkflowRunActionRepetitionDefinitionCollectionInner object if successful.
     */
    public WorkflowRunActionRepetitionDefinitionCollectionInner list(String resourceGroupName, String workflowName, String runName, String actionName) {
        return listWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName).toBlocking().single().body();
    }

    /**
     * List the workflow run action scoped repetitions.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<WorkflowRunActionRepetitionDefinitionCollectionInner> listAsync(String resourceGroupName, String workflowName, String runName, String actionName, final ServiceCallback<WorkflowRunActionRepetitionDefinitionCollectionInner> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName), serviceCallback);
    }

    /**
     * List the workflow run action scoped repetitions.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowRunActionRepetitionDefinitionCollectionInner object
     */
    public Observable<WorkflowRunActionRepetitionDefinitionCollectionInner> listAsync(String resourceGroupName, String workflowName, String runName, String actionName) {
        return listWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName).map(new Func1<ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner>, WorkflowRunActionRepetitionDefinitionCollectionInner>() {
            @Override
            public WorkflowRunActionRepetitionDefinitionCollectionInner call(ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner> response) {
                return response.body();
            }
        });
    }

    /**
     * List the workflow run action scoped repetitions.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowRunActionRepetitionDefinitionCollectionInner object
     */
    public Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner>> listWithServiceResponseAsync(String resourceGroupName, String workflowName, String runName, String actionName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (workflowName == null) {
            throw new IllegalArgumentException("Parameter workflowName is required and cannot be null.");
        }
        if (runName == null) {
            throw new IllegalArgumentException("Parameter runName is required and cannot be null.");
        }
        if (actionName == null) {
            throw new IllegalArgumentException("Parameter actionName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, workflowName, runName, actionName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner>>>() {
                @Override
                public Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<WorkflowRunActionRepetitionDefinitionCollectionInner> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<WorkflowRunActionRepetitionDefinitionCollectionInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<WorkflowRunActionRepetitionDefinitionCollectionInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get a workflow run action scoped repetition.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @param repetitionName The workflow repetition.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the WorkflowRunActionRepetitionDefinitionInner object if successful.
     */
    public WorkflowRunActionRepetitionDefinitionInner get(String resourceGroupName, String workflowName, String runName, String actionName, String repetitionName) {
        return getWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName, repetitionName).toBlocking().single().body();
    }

    /**
     * Get a workflow run action scoped repetition.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @param repetitionName The workflow repetition.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<WorkflowRunActionRepetitionDefinitionInner> getAsync(String resourceGroupName, String workflowName, String runName, String actionName, String repetitionName, final ServiceCallback<WorkflowRunActionRepetitionDefinitionInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName, repetitionName), serviceCallback);
    }

    /**
     * Get a workflow run action scoped repetition.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @param repetitionName The workflow repetition.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowRunActionRepetitionDefinitionInner object
     */
    public Observable<WorkflowRunActionRepetitionDefinitionInner> getAsync(String resourceGroupName, String workflowName, String runName, String actionName, String repetitionName) {
        return getWithServiceResponseAsync(resourceGroupName, workflowName, runName, actionName, repetitionName).map(new Func1<ServiceResponse<WorkflowRunActionRepetitionDefinitionInner>, WorkflowRunActionRepetitionDefinitionInner>() {
            @Override
            public WorkflowRunActionRepetitionDefinitionInner call(ServiceResponse<WorkflowRunActionRepetitionDefinitionInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get a workflow run action scoped repetition.
     *
     * @param resourceGroupName The resource group name.
     * @param workflowName The workflow name.
     * @param runName The workflow run name.
     * @param actionName The workflow action name.
     * @param repetitionName The workflow repetition.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the WorkflowRunActionRepetitionDefinitionInner object
     */
    public Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionInner>> getWithServiceResponseAsync(String resourceGroupName, String workflowName, String runName, String actionName, String repetitionName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (workflowName == null) {
            throw new IllegalArgumentException("Parameter workflowName is required and cannot be null.");
        }
        if (runName == null) {
            throw new IllegalArgumentException("Parameter runName is required and cannot be null.");
        }
        if (actionName == null) {
            throw new IllegalArgumentException("Parameter actionName is required and cannot be null.");
        }
        if (repetitionName == null) {
            throw new IllegalArgumentException("Parameter repetitionName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.get(this.client.subscriptionId(), resourceGroupName, workflowName, runName, actionName, repetitionName, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionInner>>>() {
                @Override
                public Observable<ServiceResponse<WorkflowRunActionRepetitionDefinitionInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<WorkflowRunActionRepetitionDefinitionInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<WorkflowRunActionRepetitionDefinitionInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<WorkflowRunActionRepetitionDefinitionInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<WorkflowRunActionRepetitionDefinitionInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
