package net.slimediamond.dragonfly.api.entity;

import java.util.function.Supplier;
import net.slimediamond.data.identification.ResourceKey;
import net.slimediamond.dragonfly.api.data.AbstractResourceKeyable;
import net.slimediamond.dragonfly.api.object.ObjectCreator;

/**
 * An entity type, holding a resource key for identification
 *
 * <p>A class should be made to manage these, for example:</p>
 * <pre>{@code
 * public static final EntityType PLAYER = new EntityType(ResourceKey.of(Client.getInstance(), "player"), () -> new Player(engine));
 * }</pre>
 */
public class EntityType extends AbstractResourceKeyable {

    private final Supplier<? extends Entity> supplier;

    public EntityType(ResourceKey resourceKey, Supplier<? extends Entity> supplier) {
        super(resourceKey);
        this.supplier = supplier;
    }

    public ObjectCreator<? extends Entity> getCreator() {
        return ObjectCreator.of(supplier);
    }

}