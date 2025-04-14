package net.slimediamond.dragonfly.api.object.camera;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.maths.vector.VectorMath;
import net.slimediamond.dragonfly.api.object.GameObject;

/**
 * The camera used for viewing objects in the game
 *
 * <p><i>TODO: Camera follow</i></p>
 */
public class Camera {
    private final DragonflyEngine engine;
    private Vector2d position;
    private GameObject following;

    public Camera(DragonflyEngine engine) {
        this.engine = engine;
    }

    /**
     * Get the position of this camera
     *
     * @return Camera position
     */
    public Vector2d getPosition() {
        return position != null ? position : Vector2d.of(0, 0);
    }

    /**
     * Set the position of the camera
     *
     * @param position Position to go to
     * @return True if the camera has been moved, false if we are following a {@link GameObject}
     */
    public boolean setPosition(Vector2d position) {
        if (!isFollowing()) {
            this.position = position;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Set the position of the camera
     *
     * @param position Position to go to
     * @return True if the camera has been moved, false if we are following a {@link GameObject}
     */
    public boolean setPosition(Vector2i position) {
        return setPosition(position.asVector2d());
    }

    /**
     * Set a {@link GameObject} for this camera to follow
     *
     * @param following The object to follow
     */
    public void setFollowing(GameObject following) {
        this.following = following;
    }

    /**
     * Stop following the current {@link GameObject}
     */
    public void stopFollowing() {
        this.following = null;
    }

    /**
     * Get whether this camera is currently following a {@link GameObject}
     *
     * @return If this is following something
     */
    public boolean isFollowing() {
        return following != null;
    }

    /**
     * Get the scale of this, for calculating on-screen coordinates
     * for frames used by this camera.
     *
     * @return Camera scale
     */
    public Vector2d getScale() {
        // the scale of the camera is determined by the below formula:
        // sx = x2 / xmin
        // sy = y2 / ymin
        // where x2, and y2 are the current size of the screen
        // and xmin and ymin are the default x and y
        return Vector2d.of(
                (double) engine.getRenderer().getScreenSizeX() / engine.getDefaultWidth(),
                (double) engine.getRenderer().getScreenSizeY() / engine.getDefaultHeight()
        );
    }

    /**
     * Get the center position (in-game coordinates) of the
     * current view of the camera at this current moment.
     *
     * @return Center coordinates
     */
    public Vector2d getCenter() {
        // Get the center coordinate of the actual frame
        Vector2i screenCenter = VectorMath.getCenter(
                Vector2i.ZERO,
                Vector2i.of(
                        engine.getRenderer().getScreenSizeX(),
                        engine.getRenderer().getScreenSizeY()
                )
        );

        return PositionTranslator.getIngamePosition(screenCenter, this);
    }
}
