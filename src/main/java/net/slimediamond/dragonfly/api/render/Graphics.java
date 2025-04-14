package net.slimediamond.dragonfly.api.render;

import net.slimediamond.dragonfly.api.data.texture.Texture;

import java.awt.Font;

/**
 * The interface for rendering graphics on something like a {@link Renderable}
 *
 * @see Renderer
 */
public interface Graphics {

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside.
     *
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The color of the rectangle
     */
    void drawRect(int x, int y, int width, int height, Color color);

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside.
     *
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    default void drawRect(int x, int y, int width, int height) {
        drawRect(x, y, width, height, Colors.BLACK);
    }

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The color of the rectangle
     */
    void fillRect(int x, int y, int width, int height, Color color);

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    default void fillRect(int x, int y, int width, int height) {
        fillRect(x, y, width, height, Colors.BLACK);
    }

    /**
     * Draw a texture at given coordinates
     *
     * @param texture The texture to draw
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    void drawTexture(Texture texture, int x, int y, int width, int height);

    /**
     * Draws a string at given coordinates
     *
     * @param content The content of the text
     * @param font The font to draw with
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     * @param color The color to draw with
     *
     * @see net.slimediamond.dragonfly.api.object.text.Text
     */
    void drawString(String content, Font font, int x, int y, Color color);

    /**
     * Draws a string at given coordinates
     *
     * @param content The content of the text
     * @param font The font to draw with
     * @param x The x coordinate to draw on
     * @param y The y coordinate to draw on
     *
     * @see net.slimediamond.dragonfly.api.object.text.Text
     */
    default void drawString(String content, Font font, int x, int y) {
        drawString(content, font, x, y, Colors.BLACK);
    }
}
