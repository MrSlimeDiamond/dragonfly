package net.slimediamond.dragonfly.api.maths.vector;

/**
 * A vector in 2D space representing two coordinates, which has
 * an integer value
 *
 * @see Vector2d
 */
public class Vector2i implements Vector2<Integer, Vector2i> {
    private final int x;
    private final int y;

    public static final Vector2i ZERO = Vector2i.of(0, 0);

    private Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public Vector2i add(Vector2i adder) {
        return Vector2i.of(adder.getX() + getX(), adder.getY() + getY());
    }

    @Override
    public Vector2i multiply(Vector2i multiplier) {
        return Vector2i.of(multiplier.getX() * getX(), multiplier.getY() * multiplier.getY());
    }

    public static Vector2i of(int x, int y) {
        return new Vector2i(x, y);
    }

    public Vector2d asVector2d() {
        return Vector2d.of(x, y);
    }

    @Override
    public String toString() {
        return "Vector2i{x=" + x + ",y=" + y + "}";
    }

    @Override
    public double dot(Vector2i other) {
        return getX() * other.getX() + getY() * other.getY();
    }
}
