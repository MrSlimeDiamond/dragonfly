package net.slimediamond.dragonfly.api.object.camera;

import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

/**
 * Util class for translating in-game coordinates into coordinates for the renderer to use, which is a different system.
 *
 * @see Vector2d
 * @see Vector2i
 */
public class PositionTranslator {

    /**
     * Convert an in-game position to a position that can be used by the renderer.
     *
     * <p>The exact formula for this is:</p>
     * <pre>{@code
     * frameX = (gameX - cameraX) * scaleX
     * frameY = (gameY - cameraY) * scaleY
     * }</pre>
     *
     * <p>In the above, <code>frame</code> is the coordinate in the frame,
     * <code>game</code> is the in-game coordinate, and <code>scale</code> is
     * the scale set by the {@link Camera}</p>
     *
     * @param ingame In-game coordinates
     * @param camera The camera from which the scale and camera position is retrieved
     * @return Translated coordinates for use in rendering frames
     * @see #getIngamePosition(Vector2i, Camera)
     */
    public static Vector2i getFramePosition(Vector2d ingame, Camera camera) {
        return Vector2i.of(
                (int) ((ingame.getX() - camera.getPosition().getX()) * camera.getScale().getX()),
                (int) ((ingame.getY() - camera.getPosition().getY()) * camera.getScale().getY())
        );
    }

    /**
     * Convert a frame position to a position that can be used in-game.
     *
     * <p>The exact formula for this is:</p>
     * <pre>
     * gameX = (frameX / scaleX) + cameraX
     * gameX = (frameY / scaleY) + cameraY
     * </pre>
     *
     * <p>In the above, <code>frame</code> is the coordinate in the frame,
     * <code>game</code> is the in-game coordinate, and <code>scale</code> is
     * the scale set by the {@link Camera}</p>
     *
     * @param framePos The coordinates in the frame
     * @param camera   The camera from which the scale and camera position is retrieved
     * @return Translated coordinates for use in-game
     * @see #getFramePosition(Vector2d, Camera)
     */
    public static Vector2d getIngamePosition(Vector2i framePos, Camera camera) {
        return Vector2d.of(
                ((double) framePos.getX() / camera.getScale().getX()) + camera.getPosition().getX(),
                ((double) framePos.getY() / camera.getScale().getY()) + camera.getPosition().getY()
        );
    }

}
