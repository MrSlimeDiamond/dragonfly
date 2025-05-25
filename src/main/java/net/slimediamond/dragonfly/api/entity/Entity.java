package net.slimediamond.dragonfly.api.entity;

import net.slimediamond.dragonfly.api.object.GameObject;

/**
 * An entity, which may be attached to another entity etc
 *
 * <p><i>TODO: Maybe just attaching game objects?</i></p>
 *
 * @see AbstractEntity
 */
public interface Entity extends GameObject {

    /**
     * Get the entity type of this entity
     *
     * @return Entity type
     */
    EntityType getEntityType();

    /**
     * Attach another entity to this entity, and have its position follow this entity.
     *
     * @param entity Entity to attach
     */
    void attach(Entity entity);

    /**
     * Detach an entity from this entity
     *
     * @param entity Entity to detach
     */
    void detach(Entity entity);

    /**
     * Get whether a certain entity is attached to this entity, which means that it will have its position updated as this one does
     *
     * @param entity Entity to check
     * @return Entity attachment
     */
    boolean isAttached(Entity entity);

}
