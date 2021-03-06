/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ProviderOperations.
 */
public class ProviderOperationsInner {
    /** The Retrofit service to perform REST calls. */
    private ProviderOperationsService service;
    /** The service client containing this operation class. */
    private ManagedLabsClientImpl client;

    /**
     * Initializes an instance of ProviderOperationsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ProviderOperationsInner(Retrofit retrofit, ManagedLabsClientImpl client) {
        this.service = retrofit.create(ProviderOperationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ProviderOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ProviderOperationsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.labservices.v2018_10_15.ProviderOperations list" })
        @GET("providers/Microsoft.LabServices/operations")
        Observable<Response<ResponseBody>> list(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.labservices.v2018_10_15.ProviderOperations listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Result of the request to list REST API operations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;OperationMetadataInner&gt; object if successful.
     */
    public PagedList<OperationMetadataInner> list() {
        ServiceResponse<Page<OperationMetadataInner>> response = listSinglePageAsync().toBlocking().single();
        return new PagedList<OperationMetadataInner>(response.body()) {
            @Override
            public Page<OperationMetadataInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<OperationMetadataInner>> listAsync(final ListOperationCallback<OperationMetadataInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;OperationMetadataInner&gt; object
     */
    public Observable<Page<OperationMetadataInner>> listAsync() {
        return listWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<OperationMetadataInner>>, Page<OperationMetadataInner>>() {
                @Override
                public Page<OperationMetadataInner> call(ServiceResponse<Page<OperationMetadataInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;OperationMetadataInner&gt; object
     */
    public Observable<ServiceResponse<Page<OperationMetadataInner>>> listWithServiceResponseAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<OperationMetadataInner>>, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(ServiceResponse<Page<OperationMetadataInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;OperationMetadataInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<OperationMetadataInner>>> listSinglePageAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<OperationMetadataInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<OperationMetadataInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<OperationMetadataInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<OperationMetadataInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<OperationMetadataInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;OperationMetadataInner&gt; object if successful.
     */
    public PagedList<OperationMetadataInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<OperationMetadataInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<OperationMetadataInner>(response.body()) {
            @Override
            public Page<OperationMetadataInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<OperationMetadataInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<OperationMetadataInner>> serviceFuture, final ListOperationCallback<OperationMetadataInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;OperationMetadataInner&gt; object
     */
    public Observable<Page<OperationMetadataInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<OperationMetadataInner>>, Page<OperationMetadataInner>>() {
                @Override
                public Page<OperationMetadataInner> call(ServiceResponse<Page<OperationMetadataInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Result of the request to list REST API operations.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;OperationMetadataInner&gt; object
     */
    public Observable<ServiceResponse<Page<OperationMetadataInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<OperationMetadataInner>>, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(ServiceResponse<Page<OperationMetadataInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Result of the request to list REST API operations.
     *
    ServiceResponse<PageImpl<OperationMetadataInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;OperationMetadataInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<OperationMetadataInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<OperationMetadataInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<OperationMetadataInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<OperationMetadataInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<OperationMetadataInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<OperationMetadataInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<OperationMetadataInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<OperationMetadataInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
