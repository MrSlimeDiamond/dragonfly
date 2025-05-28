package net.slimediamond.dragonfly.api.maths.vector;

/**
 * A vector in 2D space with a double type, meaning that it may have coordinates with decimal points
 *
 * @see Vector2i
 */
public class Vector2d implements Vector2<Double, Vector2d> {

    public static final Vector2d ZERO = Vector2d.of(0, 0);
    private final double x;
    private final double y;

    private Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector2d of(double x, double y) {
        return new Vector2d(x, y);
    }

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public Vector2d add(Vector2d other) {
        return Vector2d.of(other.getX() + getX(), other.getY() + getY());
    }

    @Override
    public Vector2d subtract(Vector2d other) {
        return Vector2d.of(getX() - other.getX(), getY() - other.getY());
    }

    @Override
    public Vector2d multiply(Vector2d multiplier) {
        return Vector2d.of(multiplier.getX() * getX(), multiplier.getY() * multiplier.getY());
    }

    public Vector2i asVector2i() {
        return Vector2i.of((int) x, (int) y);
    }

    @Override
    public String toString() {
        return "Vector2d{x=" + x + ",y=" + y + "}";
    }

    /**
     * Normalizes a decimal vector
     *
     * @return A copy of this vector, but normalized
     */
    public Vector2d normalized() {
        double length = Math.sqrt(getX() * getX() + getY() * getY());
        return length == 0 ? Vector2d.ZERO : Vector2d.of(getX() / length, getY() / length);
    }

    public boolean equals(Vector2d other) {
        return other.getX().equals(getX()) && other.getY().equals(getY());
    }

    @Override
    public double dot(Vector2d other) {
        return getX() * other.getX() + getY() * other.getY();
    }

}
