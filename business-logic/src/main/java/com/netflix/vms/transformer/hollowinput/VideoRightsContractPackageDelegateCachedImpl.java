package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.objects.delegate.HollowObjectAbstractDelegate;
import com.netflix.hollow.read.dataaccess.HollowObjectTypeDataAccess;
import com.netflix.hollow.HollowObjectSchema;
import com.netflix.hollow.read.customapi.HollowTypeAPI;
import com.netflix.hollow.objects.delegate.HollowCachedDelegate;

public class VideoRightsContractPackageDelegateCachedImpl extends HollowObjectAbstractDelegate implements HollowCachedDelegate, VideoRightsContractPackageDelegate {

    private final Long packageId;
    private final Boolean primary;
   private VideoRightsContractPackageTypeAPI typeAPI;

    public VideoRightsContractPackageDelegateCachedImpl(VideoRightsContractPackageTypeAPI typeAPI, int ordinal) {
        this.packageId = typeAPI.getPackageIdBoxed(ordinal);
        this.primary = typeAPI.getPrimaryBoxed(ordinal);
        this.typeAPI = typeAPI;
    }

    public long getPackageId(int ordinal) {
        return packageId.longValue();
    }

    public Long getPackageIdBoxed(int ordinal) {
        return packageId;
    }

    public boolean getPrimary(int ordinal) {
        return primary.booleanValue();
    }

    public Boolean getPrimaryBoxed(int ordinal) {
        return primary;
    }

    @Override
    public HollowObjectSchema getSchema() {
        return typeAPI.getTypeDataAccess().getSchema();
    }

    @Override
    public HollowObjectTypeDataAccess getTypeDataAccess() {
        return typeAPI.getTypeDataAccess();
    }

    public VideoRightsContractPackageTypeAPI getTypeAPI() {
        return typeAPI;
    }

    public void updateTypeAPI(HollowTypeAPI typeAPI) {
        this.typeAPI = (VideoRightsContractPackageTypeAPI) typeAPI;
    }

}