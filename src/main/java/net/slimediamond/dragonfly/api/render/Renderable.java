package net.slimediamond.dragonfly.api.render;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

/**
 * Something which can be rendered, using the current {@link Renderer}
 *
 * <p>This is called by {@link DragonflyEngine#render()}, please use
 * {@link DragonflyEngine#addRenderable(Renderable)} to queue one.</p>
 *
 * <p>The position at which a renderable will be rendered is
 * determined via {@link #getRenderPosition()}, which can be overridden
 * in the inheriting class</p>
 *
 * <p>Here is an example Renderable implementation:</p>
 * <pre>{@code
 * public class ExampleRenderable implements Renderable {
 *     @Override
 *     public void render(RenderContext context) {
 *         Vector2i position = context.getRenderPosition();
 *
 *         // this will make a 100x100 pixel unfilled square
 *         context.getGraphics().drawRect(position.getX(), position.getY(), 100, 100);
 *     }
 * }
 * }</pre>
 *
 * <p>The renderable may then be queued in the engine:</p>
 * <pre>{@code
 * engine.addRenderable(new ExampleRenderable());
 * }</pre>
 *
 * <p>The above will keep it rendering until it is removed</p>
 *
 * @see Renderer
 * @see RenderContext
 */
public interface Renderable {
    /**
     * Render this renderable
     *
     * @param context The context of the render
     */
    void render(RenderContext context);

    /**
     * Get the position which this will render at
     *
     * @return Render position
     */
    default Vector2i getRenderPosition() {
        return Vector2i.of(0, 0);
    }
}
