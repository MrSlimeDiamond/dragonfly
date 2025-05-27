package net.slimediamond.dragonfly.api.render;

import java.awt.Font;
import net.slimediamond.dragonfly.api.data.texture.Texture;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

/**
 * The interface for rendering graphics on something like a {@link Renderable}
 *
 * @see Renderer
 */
public interface Graphics {

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside.
     *
     * @param x      The x coordinate to draw on
     * @param y      The y coordinate to draw on
     * @param width  The width of the rectangle
     * @param height The height of the rectangle
     * @param color  The color of the rectangle
     */
    void drawRect(int x, int y, int width, int height, Color color);

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside.
     *
     * @param x      The x coordinate to draw on
     * @param y      The y coordinate to draw on
     * @param width  The width of the rectangle
     * @param height The height of the rectangle
     */
    default void drawRect(int x, int y, int width, int height) {
        drawRect(x, y, width, height, Colors.BLACK);
    }

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside
     *
     * @param position The position at which to render the rectangle
     * @param size The size of the rectangle
     * @param color The colour of the rectangle
     */
    default void drawRect(Vector2i position, Vector2i size, Color color) {
        drawRect(position.getX(), position.getY(), size.getX(), size.getY(), color);
    }

    /**
     * Draw a rectangle at the given coordinates, this has a transparent inside
     *
     * @param position The position at which to render the rectangle
     * @param size The size of the rectangle
     */
    default void drawRect(Vector2i position, Vector2i size) {
        drawRect(position, size, Colors.BLACK);
    }

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param x      The x coordinate to draw on
     * @param y      The y coordinate to draw on
     * @param width  The width of the rectangle
     * @param height The height of the rectangle
     * @param color  The color of the rectangle
     */
    void fillRect(int x, int y, int width, int height, Color color);

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param x      The x coordinate to draw on
     * @param y      The y coordinate to draw on
     * @param width  The width of the rectangle
     * @param height The height of the rectangle
     */
    default void fillRect(int x, int y, int width, int height) {
        fillRect(x, y, width, height, Colors.BLACK);
    }

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param position The position at which to render the rectangle
     * @param size The size of the rectangle
     * @param color The colour of the rectangle
     */
    default void fillRect(Vector2i position, Vector2i size, Color color) {
        fillRect(position.getX(), position.getY(), size.getX(), size.getY(), color);
    }

    /**
     * Draw a filled rectangle at the given coordinates
     *
     * @param position The position at which to render the rectangle
     * @param size The size of the rectangle
     */
    default void fillRect(Vector2i position, Vector2i size) {
        fillRect(position, size, Colors.BLACK);
    }

    /**
     * Draw a texture at given coordinates
     *
     * @param texture The texture to draw
     * @param x       The x coordinate to draw on
     * @param y       The y coordinate to draw on
     * @param width   The width of the rectangle
     * @param height  The height of the rectangle
     */
    void drawTexture(Texture texture, int x, int y, int width, int height);

    /**
     * Draws a string at given coordinates
     *
     * @param content The content of the text
     * @param font    The font to draw with
     * @param x       The x coordinate to draw on
     * @param y       The y coordinate to draw on
     * @param color   The color to draw with
     * @see net.slimediamond.dragonfly.api.object.text.Text
     */
    void drawString(String content, Font font, int x, int y, Color color);

    /**
     * Draws a string at given coordinates
     *
     * @param content The content of the text
     * @param font    The font to draw with
     * @param x       The x coordinate to draw on
     * @param y       The y coordinate to draw on
     * @see net.slimediamond.dragonfly.api.object.text.Text
     */
    default void drawString(String content, Font font, int x, int y) {
        drawString(content, font, x, y, Colors.BLACK);
    }

}
