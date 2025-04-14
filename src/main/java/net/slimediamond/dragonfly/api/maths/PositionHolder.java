package net.slimediamond.dragonfly.api.maths;

import net.slimediamond.dragonfly.api.maths.vector.Vector2d;

/**
 * Something which holds a position in the 2D space, using a {@link Vector2d}
 */
public interface PositionHolder {
    /**
     * Get the position of this position holder
     *
     * @return Position
     */
    Vector2d getPosition();
}
