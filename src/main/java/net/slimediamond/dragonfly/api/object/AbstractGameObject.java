package net.slimediamond.dragonfly.api.object;

import java.util.Objects;
import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.camera.Camera;
import net.slimediamond.dragonfly.api.object.camera.PositionTranslator;
import net.slimediamond.dragonfly.api.render.Colors;
import net.slimediamond.dragonfly.api.render.RenderContext;

/**
 * A game object implementation
 */
public abstract class AbstractGameObject implements GameObject {

    private final GameObjectType type;
    private final DragonflyEngine engine;
    protected Vector2d position;
    protected boolean spawned;

    public AbstractGameObject(DragonflyEngine engine, GameObjectType type) {
        this.engine = engine;
        this.type = type;
    }

    @Override
    public void spawn(Vector2d position) {
        this.position = position;
        this.spawned = true;
    }

    @Override
    public boolean isSpawned() {
        return spawned;
    }

    @Override
    public Vector2d getPosition() {
        return Objects.requireNonNullElse(position, Vector2d.of(0, 0));
    }

    @Override
    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public void setPosition(Vector2i position) {
        setPosition(position.asVector2d());
    }

    @Override
    public void render(RenderContext context) {
        Vector2i screenPos = context.getRenderPosition();
        Camera camera = context.getEngine().getCamera();

        int sizeX = (int) (getSize().getX() * camera.getScale().getX());
        int sizeY = (int) (getSize().getY() * camera.getScale().getY());

        if (getTexture() == null) {
            context.getGraphics().fillRect(screenPos.getX(), screenPos.getY(), sizeX, sizeY, Colors.BLUE);
        } else {
            context.getGraphics().drawTexture(
                    getTexture(),
                    screenPos.getX(), screenPos.getY(),
                    sizeX, sizeY
            );
        }
    }

    @Override
    public GameObjectType getGameObjectType() {
        return type;
    }

    @Override
    public Vector2i getRenderPosition() {
        return PositionTranslator.getFramePosition(getPosition(), engine.getCamera());
    }

}
