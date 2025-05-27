package net.slimediamond.dragonfly.api.object;

import net.slimediamond.data.identification.ResourceKey;
import net.slimediamond.dragonfly.api.data.AbstractResourceKeyable;

public class GameObjectType extends AbstractResourceKeyable {

    private final Class<? extends GameObject> clazz;

    private GameObjectType(ResourceKey resourceKey, Class<? extends GameObject> clazz) {
        super(resourceKey);
        this.clazz = clazz;
    }

    public static GameObjectType of(ResourceKey resourceKey, Class<? extends GameObject> clazz) {
        return new GameObjectType(resourceKey, clazz);
    }

    public Class<? extends GameObject> getClazz() {
        return clazz;
    }

}
