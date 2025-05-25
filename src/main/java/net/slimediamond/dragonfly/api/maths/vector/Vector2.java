package net.slimediamond.dragonfly.api.maths.vector;

/**
 * An immutable vector in 2D space, representing two coordinates
 *
 * @param <T> Number type of the vector
 */
public interface Vector2<T extends Number, Z extends Vector2<T, Z>> {
    /**
     * Get the X coordinate of this vector
     *
     * @return X coordinate
     */
    T getX();

    /**
     * Get the Y coordinate of this vector
     *
     * @return Y coordinate
     */
    T getY();

    /**
     * Adds two vectors together
     *
     * @param adder Other vector to add
     * @return Resultant addition of the two
     */
    Z add(Z adder);

    /**
     * Multiplies two vectors
     *
     * @param multiplier Other vector to multiply by
     * @return Resultant multiplied vector
     */
    Z multiply(Z multiplier);

    /**
     * Get the dot product of this vector compared to another
     *
     * <p>This is the product of the magnitudes of the two vectors</p>
     *
     * <p>This calculation is via:</p>
     * <pre>{@code
     * dot = (x1 * x2) + (y1 * y2)
     * }</pre>
     *
     * @param other The other vector to compare to
     * @return The scalar dot product result
     */
    double dot(Z other);

    /**
     * Normalizes a vector
     *
     * @return Normalized vector
     */
    default Z normalized() {
        throw new UnsupportedOperationException("Normalizing is not supported on non floating-point vectors");
    }

    /**
     * Find the distance from this vector to another
     *
     * @param other The vector to find the distance to
     * @return The distance between the vectors
     */
    default double distanceTo(Z other) {
        double dx = other.getX().doubleValue() - getX().doubleValue();
        double dy = other.getY().doubleValue() - getY().doubleValue();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
