package net.slimediamond.dragonfly.api.render;

/**
 * Pre set colors
 */
public final class Colors {

    public static final Color WHITE = Color.of(255, 255, 255);
    public static final Color BLACK = Color.of(0, 0, 0);
    public static final Color RED = Color.of(255, 0, 0);
    public static final Color GREEN = Color.of(0, 255, 0);
    public static final Color BLUE = Color.of(0, 0, 255);
    public static final Color YELLOW = Color.of(255, 255, 0);
    public static final Color CYAN = Color.of(0, 255, 255);
    public static final Color MAGENTA = Color.of(255, 0, 255);
    public static final Color ORANGE = Color.of(255, 165, 0);
    public static final Color GRAY = Color.of(128, 128, 128);
    public static final Color LIGHT_GRAY = Color.of(192, 192, 192);
    public static final Color DARK_GRAY = Color.of(64, 64, 64);
    private Colors() {
        throw new IllegalStateException("Util class");
    }

}
