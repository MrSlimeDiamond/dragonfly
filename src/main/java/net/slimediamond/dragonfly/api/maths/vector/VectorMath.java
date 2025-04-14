package net.slimediamond.dragonfly.api.maths.vector;

/**
 * Util class for doing maths with vector objects, like {@link Vector2d}
 */
public class VectorMath {

    /**
     * Get the distances (x and y) between two sets of coordinates
     *
     * <p>The equation is effectively the centre of both of these, divided by 2</p>
     *
     * <p>In the below box, <code>c</code> represents the centre,
     * <code>dx</code> represents the distance from the centre on the x axis, and
     * <code>dy</code> represents the distance from the centre on the y axis.</p>
     *
     * <p>Don't worry, it's not calculus ;D</p>
     * <pre>
     * +-----------------------------+
     * |                             |
     * |                             |
     * |      dx                     |
     * |<------------>c              |
     * |              ^              |
     * |              |              |
     * |              | dy           |
     * |              |              |
     * |              V              |
     * +-----------------------------+
     * </pre>
     *
     * @param pos1 Position 1
     * @param pos2 Position 2
     * @return Distances from the centre of both coordinates
     */
    public static Vector2d getDistances(Vector2d pos1, Vector2d pos2) {
        // English spelling > American Spelling :)
        Vector2d centre = getCenter(pos1, pos2);

        return Vector2d.of(
                centre.getX() / 2,
                centre.getY() / 2
        );
    }

    /**
     * Get the distances (x and y) between two sets of coordinates
     *
     * <p>The equation is effectively the centre of both of these, divided by 2</p>
     *
     * <p>In the below box, <code>c</code> represents the centre,
     * <code>dx</code> represents the distance from the centre on the x axis, and
     * <code>dy</code> represents the distance from the centre on the y axis.</p>
     *
     * <p>Don't worry, it's not calculus ;D</p>
     * <pre>
     * +-----------------------------+
     * |                             |
     * |                             |
     * |      dx                     |
     * |<------------>c              |
     * |              ^              |
     * |              |              |
     * |              | dy           |
     * |              |              |
     * |              V              |
     * +-----------------------------+
     * </pre>
     *
     * @param pos1 Position 1
     * @param pos2 Position 2
     * @return Distances from the centre of both coordinates
     */
    public static Vector2i getDistances(Vector2i pos1, Vector2i pos2) {
        return getDistances(pos1.asVector2d(), pos2.asVector2d()).asVector2i();
    }

    /**
     * Gets the center between two 2D coordinates
     *
     * @param pos1 Position 1
     * @param pos2 Position 2
     * @return Center between the two positions
     */
    public static Vector2d getCenter(Vector2d pos1, Vector2d pos2) {
        return Vector2d.of(
                (pos1.getX() + pos2.getX()) / 2,
                (pos1.getY() + pos2.getY()) / 2
        );
    }

    /**
     * Gets the center between two 2D coordinates
     *
     * @param pos1 Position 1
     * @param pos2 Position 2
     * @return Center between the two positions
     */
    public static Vector2i getCenter(Vector2i pos1, Vector2i pos2) {
        return getCenter(pos1.asVector2d(), pos2.asVector2d()).asVector2i();
    }
}
