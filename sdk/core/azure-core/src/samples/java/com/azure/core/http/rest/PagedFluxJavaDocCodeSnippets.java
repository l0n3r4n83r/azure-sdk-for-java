// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.http.rest;

import com.azure.core.util.paging.PageRetriever;
import org.reactivestreams.Subscription;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Code snippets for {@link PagedFlux}
 */
public final class PagedFluxJavaDocCodeSnippets {

    /**
     * Code snippets for showing usage of {@link PagedFlux} in class docs
     */
    public void classDocSnippet() {
        PagedFlux<Integer> pagedFlux = createAnInstance();
        // BEGIN: com.azure.core.http.rest.pagedflux.items
        // Subscribe to process one item at a time
        pagedFlux
            .log()
            .subscribe(item -> System.out.println("Processing item " + item),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.core.http.rest.pagedflux.items

        // BEGIN: com.azure.core.http.rest.pagedflux.pages
        // Subscribe to process one page at a time from the beginning
        pagedFlux
            .byPage()
            .log()
            .subscribe(page -> System.out.println("Processing page containing " + page.getItems()),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.core.http.rest.pagedflux.pages

        // BEGIN: com.azure.core.http.rest.pagedflux.pagesWithContinuationToken
        // Subscribe to process one page at a time starting from a page associated with
        // a continuation token
        String continuationToken = getContinuationToken();
        pagedFlux
            .byPage(continuationToken)
            .log()
            .doOnSubscribe(ignored -> System.out.println(
                "Subscribed to paged flux processing pages starting from: " + continuationToken))
            .subscribe(page -> System.out.println("Processing page containing " + page.getItems()),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.core.http.rest.pagedflux.pagesWithContinuationToken
    }

    /**
     * Code snippets for creating an instance of {@link PagedFlux}
     * @return An instance of {@link PagedFlux}
     */
    public PagedFlux<Integer> createAnInstance() {

        // BEGIN: com.azure.core.http.rest.pagedflux.instantiation
        // A supplier that fetches the first page of data from source/service
        Supplier<Mono<PagedResponse<Integer>>> firstPageRetriever = () -> getFirstPage();

        // A function that fetches subsequent pages of data from source/service given a continuation token
        Function<String, Mono<PagedResponse<Integer>>> nextPageRetriever =
            continuationToken -> getNextPage(continuationToken);

        PagedFlux<Integer> pagedFlux = new PagedFlux<>(firstPageRetriever,
            nextPageRetriever);
        // END: com.azure.core.http.rest.pagedflux.instantiation

        // BEGIN: com.azure.core.http.rest.pagedflux.singlepage.instantiation
        // A supplier that fetches the first page of data from source/service
        Supplier<Mono<PagedResponse<Integer>>> firstPageRetrieverFunction = () -> getFirstPage();

        PagedFlux<Integer> pagedFluxInstance = new PagedFlux<>(firstPageRetrieverFunction,
            nextPageRetriever);
        // END: com.azure.core.http.rest.pagedflux.singlepage.instantiation
        return pagedFlux;
    }

    /**
     * Code snippets for using {@link PagedFlux#byPage()} and {@link PagedFlux#byPage(String)}
     */
    public void byPageSnippet() {
        PagedFlux<Integer> pagedFlux = createAnInstance();

        // BEGIN: com.azure.core.http.rest.pagedflux.bypage
        // Start processing the results from first page
        pagedFlux.byPage()
            .log()
            .doOnSubscribe(ignoredVal -> System.out.println(
                "Subscribed to paged flux processing pages starting from first page"))
            .subscribe(page -> System.out.println("Processing page containing " + page.getItems()),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.core.http.rest.pagedflux.bypage

        // BEGIN: com.azure.core.http.rest.pagedflux.bypage#String
        // Start processing the results from a page associated with the continuation token
        String continuationToken = getContinuationToken();
        pagedFlux.byPage(continuationToken)
            .log()
            .doOnSubscribe(ignoredVal -> System.out.println(
                "Subscribed to paged flux processing page starting from " + continuationToken))
            .subscribe(page -> System.out.println("Processing page containing " + page.getItems()),
                error -> System.err.println("Error occurred " + error),
                () -> System.out.println("Completed processing."));
        // END: com.azure.core.http.rest.pagedflux.bypage#String
    }

    /**
     * Code snippets for using {@link PagedFlux#subscribe(CoreSubscriber)}
     */
    public void byTSnippet() {
        PagedFlux<Integer> pagedFlux = createAnInstance();

        // BEGIN: com.azure.core.http.rest.pagedflux.subscribe
        pagedFlux.subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("Subscribed to paged flux processing items");
                super.hookOnSubscribe(subscription);
            }

            @Override
            protected void hookOnNext(Integer value) {
                System.out.println("Processing item " + value);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("Completed processing");
            }
        });
        // END: com.azure.core.http.rest.pagedflux.subscribe
    }

    /**
     * Code snippets for using {@link PagedFlux#create(Supplier)}
     * to create a PagedFlux by applying decoration on another PagedFlux.
     */
    public void pagedFluxFromPagedFlux() {
        // BEGIN: com.azure.core.http.rest.pagedflux.create.decoration

        // Transform a PagedFlux with Integer items to PagedFlux of String items.
        final PagedFlux<Integer> intPagedFlux = createAnInstance();

        // PagedResponse<Integer> to PagedResponse<String> mapper
        final Function<PagedResponse<Integer>, PagedResponse<String>> responseMapper
            = intResponse -> new PagedResponseBase<Void, String>(intResponse.getRequest(),
                intResponse.getStatusCode(),
                intResponse.getHeaders(),
                intResponse.getValue()
                    .stream()
                    .map(intValue -> Integer.toString(intValue)).collect(Collectors.toList()),
                intResponse.getContinuationToken(),
                null);

        final Supplier<PageRetriever<String, PagedResponse<String>>> provider
            = new Supplier<PageRetriever<String, PagedResponse<String>>>() {
                @Override
                public PageRetriever<String, PagedResponse<String>> get() {
                    return (continuationToken, pageSize) -> {
                        Flux<PagedResponse<Integer>> flux = (continuationToken == null)
                            ? intPagedFlux.byPage()
                            : intPagedFlux.byPage(continuationToken);
                        return flux.map(responseMapper);
                    };
                }
            };
        PagedFlux<String> strPagedFlux = PagedFlux.create(provider);

        // Create a PagedFlux from a PagedFlux with all exceptions mapped to a specific exception.
        final PagedFlux<Integer> pagedFlux = createAnInstance();
        final Supplier<PageRetriever<String, PagedResponse<Integer>>> eprovider
            = new Supplier<PageRetriever<String, PagedResponse<Integer>>>() {
                @Override
                public PageRetriever<String, PagedResponse<Integer>> get() {
                    return (continuationToken, pageSize) -> {
                        Flux<PagedResponse<Integer>> flux = (continuationToken == null)
                            ? pagedFlux.byPage()
                            : pagedFlux.byPage(continuationToken);
                        return flux.onErrorMap(t -> new PaginationException(t));
                    };
                }
            };
        final PagedFlux<Integer> exceptionMappedPagedFlux = PagedFlux.create(eprovider);
        // END: com.azure.core.http.rest.pagedflux.create.decoration
    }

    /**
     * Implementation not provided
     *
     * @return A continuation token
     */
    private String getContinuationToken() {
        return null;
    }

    /**
     * Implementation not provided
     *
     * @param continuationToken Token to fetch the next page
     * @return A {@link Mono} of {@link PagedResponse} containing items of type {@code Integer}
     */
    private Mono<PagedResponse<Integer>> getNextPage(String continuationToken) {
        return null;
    }

    /**
     * Implementation not provided
     *
     * @return A {@link Mono} of {@link PagedResponse} containing items of type {@code Integer}
     */
    private Mono<PagedResponse<Integer>> getFirstPage() {
        return null;
    }

    class PaginationException extends RuntimeException {
        PaginationException(Throwable ex) {
            super(ex);
        }
    }
}
