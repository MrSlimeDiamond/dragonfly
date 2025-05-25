package net.slimediamond.dragonfly.api.data;

import net.slimediamond.data.identification.ResourceKey;
import net.slimediamond.data.identification.ResourceKeyable;

public abstract class AbstractResourceKeyable implements ResourceKeyable {

    private final ResourceKey resourceKey;

    public AbstractResourceKeyable(ResourceKey resourceKey) {
        this.resourceKey = resourceKey;
    }

    @Override
    public ResourceKey getResourceKey() {
        return resourceKey;
    }

}
