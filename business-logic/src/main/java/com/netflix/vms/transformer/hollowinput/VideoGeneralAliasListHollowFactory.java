package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.objects.provider.HollowFactory;
import com.netflix.hollow.read.dataaccess.HollowTypeDataAccess;
import com.netflix.hollow.read.customapi.HollowTypeAPI;
import com.netflix.hollow.objects.delegate.HollowListCachedDelegate;

public class VideoGeneralAliasListHollowFactory<T extends VideoGeneralAliasListHollow> extends HollowFactory<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T newHollowObject(HollowTypeDataAccess dataAccess, HollowTypeAPI typeAPI, int ordinal) {
        return (T)new VideoGeneralAliasListHollow(((VideoGeneralAliasListTypeAPI)typeAPI).getDelegateLookupImpl(), ordinal);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T newCachedHollowObject(HollowTypeDataAccess dataAccess, HollowTypeAPI typeAPI, int ordinal) {
        return (T)new VideoGeneralAliasListHollow(new HollowListCachedDelegate((VideoGeneralAliasListTypeAPI)typeAPI, ordinal), ordinal);
    }

}