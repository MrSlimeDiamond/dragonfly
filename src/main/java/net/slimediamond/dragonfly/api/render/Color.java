package net.slimediamond.dragonfly.api.render;

/**
 * A color
 *
 * <p>(or colour, if you're English like me!)</p>
 */
public class Color {
    private final int r;
    private final int g;
    private final int b;

    private Color(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Get the red value of this color
     *
     * @return Red value
     */
    public int getRed() {
        return r;
    }

    /**
     * Get the green value of this color
     *
     * @return Green value
     */
    public int getGreen() {
        return g;
    }

    /**
     * Get the blue value of this color
     *
     * @return Blue value
     */
    public int getBlue() {
        return b;
    }

    /**
     * The {@link Color} factory
     *
     * @param r Red value of the color
     * @param g Green value of the color
     * @param b Blue value of the color
     * @return The resultant color instance
     */
    public static Color of(int r, int g, int b) {
        return new Color(r, g, b);
    }

    @Override
    public String toString() {
        return "Color{r=" + r + ",g=" + g + ",b=" + b + "}";
    }
}
