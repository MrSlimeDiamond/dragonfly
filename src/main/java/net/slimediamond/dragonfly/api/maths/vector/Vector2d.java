package net.slimediamond.dragonfly.api.maths.vector;

/**
 * A vector in 2D space with a double type, meaning that it may have
 * coordinates with decimal points
 *
 * @see Vector2i
 */
public class Vector2d implements Vector2<Double, Vector2d> {
    private final double x;
    private final double y;

    public static final Vector2d ZERO = Vector2d.of(0, 0);

    private Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
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
    public Vector2d add(Vector2d adder) {
        return Vector2d.of(adder.getX() + getX(), adder.getY() + getY());
    }

    @Override
    public Vector2d multiply(Vector2d multiplier) {
        return Vector2d.of(multiplier.getX() * getX(), multiplier.getY() * multiplier.getY());
    }

    public static Vector2d of(double x, double y) {
        return new Vector2d(x, y);
    }

    public Vector2i asVector2i() {
        return Vector2i.of((int) x, (int) y);
    }

    @Override
    public String toString() {
        return "Vector2d{x=" + x + ",y=" + y + "}";
    }

    @Override
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
