package net.slimediamond.dragonfly.api;

import net.slimediamond.dragonfly.api.input.InputHandler;
import net.slimediamond.dragonfly.api.logger.Logger;
import net.slimediamond.dragonfly.api.render.Renderer;

/**
 * The configuration for {@link DragonflyEngine}
 *
 * <p>Intended usage of this is the {@link #builder()}</p>
 *
 * <p>Below is the possible settings, their description, and the default value</p>
 * <div style="width: 400px; font-size: 8px">
 * <table>
 *     <tr>
 *         <th>Value</th>
 *         <th>Description</th>
 *         <th>Default</th>
 *     </tr>
 *     <tr>
 *         <td>Title</td>
 *         <td>The title shown at the top of the game window</td>
 *         <td>"Dragonfly Engine"</td>
 *     </tr>
 *     <tr>
 *         <td>Default width</td>
 *         <td>The width of the window when the player launches the game</td>
 *         <td>680</td>
 *     </tr>
 *     <tr>
 *         <td>Default height</td>
 *         <td>The height of the window when the player launches the game</td>
 *         <td>480</td>
 *     </tr>
 *     <tr>
 *         <td>Logger</td>
 *         <td>The {@link Logger} that the engine will use</td>
 *         <td><i>None</i></td>
 *     </tr>
 *     <tr>
 *         <td>Renderer</td>
 *         <td>The {@link Renderer} that the engine will use</td>
 *         <td><i>None</i> - <b>required</b></td>
 *     </tr>
 *     <tr>
 *         <td>Input handler</td>
 *         <td>The {@link InputHandler} that the engine will use</td>
 *         <td><i>None</i> - <b>required</b></td>
 *     </tr>
 * </table>
 * </div>
 *
 * @see DragonflyEngine
 */
public interface EngineConfiguration {

    static Builder builder() {
        return new Builder();
    }

    /**
     * The title of the window
     *
     * @return Window title
     */
    String getTitle();

    /**
     * Get the default width of the window
     *
     * @return Window width
     */
    int getDefaultWidth();

    /**
     * Get the default height of the window
     *
     * @return Window height
     */
    int getDefaultHeight();

    /**
     * Get this engine's logger
     *
     * @return Logger
     */
    Logger getLogger();

    /**
     * Get the renderer this engine will use
     *
     * @return Engine renderer
     */
    Renderer getRenderer();

    /**
     * Get the input handler this engine will use
     *
     * @return Input handler
     */
    InputHandler getInputHandler();

    class Builder {

        private String title = "Dragonfly engine";
        private int defaultWidth = 680;
        private int defaultHeight = 480;
        private Logger logger;
        private Renderer renderer;
        private InputHandler inputHandler;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder width(int defaultWidth) {
            this.defaultWidth = defaultWidth;
            return this;
        }

        public Builder height(int defaultHeight) {
            this.defaultHeight = defaultHeight;
            return this;
        }

        public Builder logger(Logger logger) {
            this.logger = logger;
            return this;
        }

        public Builder renderer(Renderer renderer) {
            this.renderer = renderer;
            return this;
        }

        public Builder inputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        public EngineConfiguration build() {
            return new EngineConfiguration() {
                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public int getDefaultWidth() {
                    return defaultWidth;
                }

                @Override
                public int getDefaultHeight() {
                    return defaultHeight;
                }

                @Override
                public Logger getLogger() {
                    return logger;
                }

                @Override
                public Renderer getRenderer() {
                    return renderer;
                }

                @Override
                public InputHandler getInputHandler() {
                    return inputHandler;
                }
            };
        }

    }

}
