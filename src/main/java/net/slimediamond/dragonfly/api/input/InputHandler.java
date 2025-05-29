package net.slimediamond.dragonfly.api.input;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.input.keybind.Keybinds;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

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

    private static final Map<String, Vector2i> MOVEMENT = Map.of(
            Keybinds.UP, Vector2i.of(0, -1),
            Keybinds.DOWN, Vector2i.of(0, 1),
            Keybinds.LEFT, Vector2i.of(-1, 0),
            Keybinds.RIGHT, Vector2i.of(1, 0)
    );
    private static final Map<Axis, List<String>> AXISES = Map.of(
            Axis.Y, List.of(Keybinds.UP, Keybinds.DOWN),
            Axis.X, List.of(Keybinds.LEFT, Keybinds.RIGHT)
    );
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

    /**
     * Detect whether a keybind (allocated by a string) is
     * currently being held
     *
     * @param bind The bind to check
     * @return Whether it is being pressed
     */
    public boolean isBindDown(String bind) {
        return Keybinds.getKeys(bind).stream().anyMatch(this::isKeyDown);
    }

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
            for (String bind : AXISES.get(axis)) {
                if (MOVEMENT.containsKey(bind) && isBindDown(bind)) {
                    Vector2i movementVec = MOVEMENT.get(bind);
                    return (axis == Axis.X) ? movementVec.getX() : movementVec.getY();
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

}
