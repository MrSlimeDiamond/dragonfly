package net.slimediamond.dragonfly.api.object;

import net.slimediamond.data.identification.ResourceKey;
import net.slimediamond.dragonfly.api.data.AbstractResourceKeyable;

import java.util.function.Supplier;

public class GameObjectType extends AbstractResourceKeyable {
    private final Supplier<? extends GameObject> supplier;

    public GameObjectType(ResourceKey resourceKey, Supplier<? extends GameObject> supplier) {
        super(resourceKey);
        this.supplier = supplier;
    }

    public ObjectCreator<? extends GameObject> getCreator() {
        return ObjectCreator.of(supplier);
    }
}
