package net.slimediamond.dragonfly.api.entity;

import java.util.ArrayList;
import java.util.List;
import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.object.AbstractGameObject;
import net.slimediamond.dragonfly.api.object.DragonflyGameObjectTypes;

/**
 * A basic implementation of an entity
 *
 * <p>Creating an abstract entity requires some kind of {@link EntityType} reference. This can be done via a static class.</p>
 */
public abstract class AbstractEntity extends AbstractGameObject implements Entity {

    private final EntityType entityType;
    private final List<Entity> attachedEntities = new ArrayList<>();

    protected AbstractEntity(DragonflyEngine engine, EntityType entityType) {
        super(engine, DragonflyGameObjectTypes.ENTITY);
        this.entityType = entityType;
        engine.getLogger().debug("Entity created with type: " + entityType.getResourceKey().toString());
    }

    @Override
    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public void setPosition(Vector2d position) {
        this.position = position;
        this.attachedEntities.forEach(entity -> {
            // update the positions of attached entities
            // TODO: Make them keep their original offset somehow
            entity.setPosition(getPosition());
        });
    }

    @Override
    public void attach(Entity entity) {
        attachedEntities.add(entity);
    }

    @Override
    public void detach(Entity entity) {
        attachedEntities.remove(entity);
    }

    @Override
    public boolean isAttached(Entity entity) {
        return attachedEntities.contains(entity);
    }

}
