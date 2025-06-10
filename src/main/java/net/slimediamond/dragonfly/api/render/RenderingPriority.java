package net.slimediamond.dragonfly.api.render;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * The priority of rendering a {@link Renderable}
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RenderingPriority {

    /**
     * The rendering priority of the {@link Renderable}
     *
     * @return Render priority
     */
    Priority value();

    /**
     * A rendering priority
     */
    enum Priority {

        FIRST(1),
        MEDIUM(2),
        LAST(3);

        private final int weight;

        Priority(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

    }

}
