package net.slimediamond.dragonfly.api.entity.manager;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.entity.Entity;
import net.slimediamond.dragonfly.api.entity.EntityType;
import net.slimediamond.dragonfly.api.manager.AbstractManager;
import net.slimediamond.dragonfly.api.object.manager.GameObjectManager;

import java.lang.reflect.InvocationTargetException;

public class EntityManager extends AbstractManager<Entity> {
    private final GameObjectManager gameObjectManager;
    private final DragonflyEngine engine;

    public EntityManager(GameObjectManager gameObjectManager, DragonflyEngine engine) {
        this.gameObjectManager = gameObjectManager;
        this.engine = engine;
    }

    @Override
    public void add(Entity entity) {
        gameObjectManager.add(entity);
        super.add(entity);
    }

    @Override
    public void remove(Entity entity) {
        gameObjectManager.remove(entity);
        super.remove(entity);
    }

    public Class<? extends Entity> getEntityClass(EntityType entityType) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T extends Entity> T spawnEntity(EntityType entityType) {
        try {
            T entity = (T)getEntityClass(entityType).getConstructor(DragonflyEngine.class).newInstance(engine);
            add(entity);
            return entity;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
