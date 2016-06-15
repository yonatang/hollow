package com.netflix.vms.transformer.hollowinput;

import com.netflix.hollow.objects.delegate.HollowObjectDelegate;

public interface ArtworkRecipeDelegate extends HollowObjectDelegate {

    public int getRecipeNameOrdinal(int ordinal);

    public int getCdnFolderOrdinal(int ordinal);

    public int getExtensionOrdinal(int ordinal);

    public int getHostNameOrdinal(int ordinal);

    public ArtworkRecipeTypeAPI getTypeAPI();

}