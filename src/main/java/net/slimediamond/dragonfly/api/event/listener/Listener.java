package net.slimediamond.dragonfly.api.event.listener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marks a {@link java.lang.reflect.Method} as a listener, which means
 * it will pick up any {@link net.slimediamond.dragonfly.api.event.Event}s which are defined
 * in the method's parameters.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Listener {

}
