package net.slimediamond.dragonfly.api.render;

import net.slimediamond.dragonfly.api.logger.LoggerWrapper;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;

/**
 * A renderer for the Dragonfly engine, displaying graphics on screen.
 *
 * <p>Implementation of this exist in the <code>dragonfly-renderer-*</code> directories</p>
 *
 * <p>This <strong>must</strong> be set when constructing an engine, otherwise
 * there will be no graphics on screen (and probably an error!)</p>
 *
 * @see net.slimediamond.dragonfly.api.EngineConfiguration
 */
public interface Renderer {

    /**
     * Initialize the renderer, and create the game window
     *
     * @param title  The title of the game window <br>
     *               <strong>Note:</strong> This will have the renderer's name
     *               suffixed (e.g. <code> - OpenGL</code>)
     * @param width  The width of the window by default
     * @param height The height of the window by default
     */
    void init(String title, int width, int height);

    /**
     * Clear the screen
     */
    void clear();

    /**
     * Render graphics
     */
    void render();

    /**
     * Stop rendering. This is called on game exit.
     */
    void stop();

    /**
     * Gets whether the renderer "should be displaying a window"
     *
     * @return Window display
     */
    boolean shouldDisplayWindow();

    /**
     * Gets the window width
     *
     * @return Window width
     */
    int getScreenSizeX();

    /**
     * Gets the window height
     *
     * @return Window height
     */
    int getScreenSizeY();

    /**
     * Get the size of the window
     *
     * @return Window size
     */
    default Vector2i getScreenSize() {
        return Vector2i.of(getScreenSizeX(), getScreenSizeY());
    }

    /**
     * Create a graphics backend
     *
     * @return Graphics
     * @see Renderable
     */
    Graphics createGraphics();

    /**
     * Set the logger wrapper for the renderer to log with
     *
     * @param logger Logger to use
     */
    void setLogger(LoggerWrapper logger);

}
