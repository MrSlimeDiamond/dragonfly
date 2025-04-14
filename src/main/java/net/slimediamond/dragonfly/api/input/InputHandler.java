package net.slimediamond.dragonfly.api.input;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

/**
 * Handles inputs for an engine
 *
 * <p>This does both the 1D and 2D axis, via the respective methods
 * in the respective classes: {@link #get1D()} or {@link #get2D()}</p>
 *
 * <p>When a method to get movement on axis is called, this will check for the held keys
 * and determine if one is on a mapping (which is yet to be made configurable)</p>
 *
 * <p>You may get if a key is down via the {@link #isKeyDown(Integer)} method, where
 * the integer is the key's key code.</p>
 *
 * @see _1D
 * @see _2D
 */
public abstract class InputHandler {
    private final _1D _1d;
    private final _2D _2d;

    public InputHandler() {
        this._1d = new _1D();
        this._2d = new _2D();
    }

    /**
     * Gets 1D input handler
     *
     * @return 1D input
     */
    public _1D get1D() {
        return _1d;
    }

    /**
     * Gets the 2D input handler
     *
     * @return 2D input
     */
    public _2D get2D() {
        return _2d;
    }

    // TODO: user configuration
    private static final Map<Integer, Vector2i> movement = Map.of(
            KeyEvent.VK_W, Vector2i.of(0, -1),
            KeyEvent.VK_S, Vector2i.of(0, 1),
            KeyEvent.VK_A, Vector2i.of(-1, 0),
            KeyEvent.VK_D, Vector2i.of(1, 0),

            KeyEvent.VK_UP, Vector2i.of(0, -1),
            KeyEvent.VK_DOWN, Vector2i.of(0, 1),
            KeyEvent.VK_LEFT, Vector2i.of(-1, 0),
            KeyEvent.VK_RIGHT, Vector2i.of(1, 0)
    );

    private static final Map<Axis, List<Integer>> axises = Map.of(
            Axis.Y, List.of(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_UP, KeyEvent.VK_DOWN),
            Axis.X, List.of(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT)
    );

    /**
     * The <strong>1D</strong> input handler.
     *
     * <p>This will allow getting input on <strong>one axis</strong></p>
     */
    public class _1D {
        /**
         * Get a specific 1D axis of movement
         *
         * @param axis The axis
         * @return Movement on that axis
         */
        public int getAxis(Axis axis) {
            for (Integer key : axises.get(axis)) {
                if (isKeyDown(key)) {
                    if (movement.containsKey(key)) {
                        Vector2i movementVec = movement.get(key);
                        return (axis == Axis.X) ? movementVec.getX() : movementVec.getY();
                    }
                }
            }
            return 0;
        }
    }

    /**
     * The <strong>2D</strong> input handler
     *
     * @see #getMovementAxis()
     */
    public class _2D {
        /**
         * Get input on the <strong>movement</strong> axis, consisting of
         * <code>x</code> and <code>y</code>
         *
         * @return Movement axis
         */
        public Vector2d getMovementAxis() {
            return Vector2d.of(get1D().getAxis(Axis.X), get1D().getAxis(Axis.Y));
        }
    }

    /**
     * Detect whether a key is down
     *
     * @param key The key code of the key to check
     * @return Whether that key is down
     */
    public abstract boolean isKeyDown(Integer key);

    /**
     * Begin listening for inputs
     */
    public abstract void begin(DragonflyEngine engine);
}
