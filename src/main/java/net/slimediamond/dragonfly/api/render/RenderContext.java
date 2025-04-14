package net.slimediamond.dragonfly.api.render;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

/**
 * The context for rendering an object, providing {@link Graphics},
 * and a position to render at.
 *
 * @see Renderable
 */
public interface RenderContext {
    /**
     * Get the engine we are rendering for
     *
     * @return Engine
     */
    DragonflyEngine getEngine();

    /**
     * Get the graphics backend
     *
     * @return graphics
     */
    Graphics getGraphics();

    /**
     * Get the position at which to render this on the frame
     *
     * @return Frame render position
     */
    Vector2i getRenderPosition();
}
