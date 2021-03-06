/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * jkl
 */

package com.microsoft.azure.management.peering.v2019_08_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.peering.v2019_08_01_preview.PeerAsns;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import rx.Completable;
import com.microsoft.azure.management.peering.v2019_08_01_preview.PeerAsn;
import com.microsoft.azure.arm.utils.PagedListConverter;

class PeerAsnsImpl extends WrapperImpl<PeerAsnsInner> implements PeerAsns {
    private PagedListConverter<PeerAsnInner, PeerAsn> converter;
    private final PeeringManager manager;

    PeerAsnsImpl(PeeringManager manager) {
        super(manager.inner().peerAsns());
        this.manager = manager;
        this.converter = new PagedListConverter<PeerAsnInner, PeerAsn>() {
            @Override
            public Observable<PeerAsn> typeConvertAsync(PeerAsnInner inner) {
                return Observable.just((PeerAsn) wrapModel(inner));
            }
        };
    }

    public PeeringManager manager() {
        return this.manager;
    }

    @Override
    public PeerAsnImpl define(String name) {
        return wrapModel(name);
    }

    private PeerAsnImpl wrapModel(PeerAsnInner inner) {
        return  new PeerAsnImpl(inner, manager());
    }

    private PeerAsnImpl wrapModel(String name) {
        return new PeerAsnImpl(name, this.manager());
    }

    @Override
    public Observable<PeerAsn> getAsync(String peerAsnName) {
        PeerAsnsInner client = this.inner();
        return client.getAsync(peerAsnName)
        .map(new Func1<PeerAsnInner, PeerAsn>() {
            @Override
            public PeerAsn call(PeerAsnInner inner) {
                return new PeerAsnImpl(inner, manager());
            }
        });
    }

    @Override
    public Completable deleteAsync(String peerAsnName) {
        PeerAsnsInner client = this.inner();
        return client.deleteAsync(peerAsnName).toCompletable();
    }

    @Override
    public PagedList<PeerAsn> list() {
        PeerAsnsInner client = this.inner();
        return converter.convert(client.list());
    }

    @Override
    public Observable<PeerAsn> listAsync() {
        PeerAsnsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<PeerAsnInner>, Iterable<PeerAsnInner>>() {
            @Override
            public Iterable<PeerAsnInner> call(Page<PeerAsnInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PeerAsnInner, PeerAsn>() {
            @Override
            public PeerAsn call(PeerAsnInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
