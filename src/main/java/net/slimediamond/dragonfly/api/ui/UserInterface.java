package net.slimediamond.dragonfly.api.ui;

import net.slimediamond.dragonfly.api.object.text.Text;
import net.slimediamond.dragonfly.api.render.RenderContext;
import net.slimediamond.dragonfly.api.render.Renderable;
import net.slimediamond.dragonfly.api.render.RenderingPriority;

import java.util.function.Consumer;

/**
 * A user interface which is shown in-game
 */
public interface UserInterface extends Renderable {

    /**
     * Get the title shown at the top of the user interface
     *
     * @return Interface title
     */
    Text getTitle();

    /**
     * Get whether the UI is currently visible
     *
     * @return UI visibility
     */
    boolean isVisible();

    /**
     * Get a mutable view of this user interface, where its properties can be changed
     *
     * <p>Note: This is <b>not</b> a copy.</p>
     *
     * @return Mutable view
     */
    Mutable asMutable();

    /**
     * A mutable version of {@link UserInterface}
     *
     * <p>On this, properties can be changed</p>
     */
    interface Mutable extends UserInterface {

        /**
         * Set the title of the UI
         *
         * @param title The title to set
         */
        void setTitle(Text title);

        /**
         * Set whether the UI is currently visible
         *
         * @param visible UI visibility
         */
        void setVisible(boolean visible);

    }

    class Impl implements UserInterface.Mutable {

        private Text title;
        private boolean visible;
        private final Consumer<RenderContext> consumer;

        public Impl(Text title, boolean visible, Consumer<RenderContext> consumer) {
            this.title = title;
            this.visible = visible;
            this.consumer = consumer;
        }

        @Override
        public void setTitle(Text title) {
            this.title = title;
        }

        @Override
        public void setVisible(boolean visible) {
            this.visible = visible;
        }

        @Override
        public Text getTitle() {
            return title;
        }

        @Override
        public boolean isVisible() {
            return visible;
        }

        @Override
        public Mutable asMutable() {
            return this;
        }

        @Override
        public void render(RenderContext context) {
            // TODO: Render a nice box with the title on it.
            // For now, we'll just show whatever the hell we want.
            // This makes title utterly useless unless implemented by the dev.
            consumer.accept(context);
        }

    }

    abstract class Abstract implements UserInterface {

        private final Text title;
        protected boolean visible;

        public Abstract(Text title) {
            this.title = title;
        }

        @RenderingPriority(RenderingPriority.Priority.LAST)
        @Override
        public void render(RenderContext context) {
            // TODO: Make a nice box with the title or something
            if (isVisible()) {
                this.renderUI(context);
            }
        }

        @Override
        public Text getTitle() {
            return title;
        }

        @Override
        public boolean isVisible() {
            return visible;
        }

        @Override
        public Mutable asMutable() {
            // a mutable *copy*, rather, but probably won't be too important
            return new Impl(title, visible, this::renderUI);
        }

        public abstract void renderUI(RenderContext context);

    }

    static UserInterface from(Text title, Consumer<RenderContext> consumer) {
        return new Impl(title, true, consumer);
    }

    // TODO: builder factory which provides a builder for this an similar classes

}
