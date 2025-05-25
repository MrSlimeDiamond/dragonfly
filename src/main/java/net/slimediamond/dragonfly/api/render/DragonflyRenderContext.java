package net.slimediamond.dragonfly.api.render;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

public class DragonflyRenderContext implements RenderContext {

    private final DragonflyEngine engine;
    private final Graphics graphics;
    private final Vector2i renderPosition;

    public DragonflyRenderContext(DragonflyEngine engine, Graphics graphics, Vector2i renderPosition) {
        this.engine = engine;
        this.graphics = graphics;
        this.renderPosition = renderPosition;
    }

    @Override
    public DragonflyEngine getEngine() {
        return engine;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Vector2i getRenderPosition() {
        return renderPosition;
    }

}
