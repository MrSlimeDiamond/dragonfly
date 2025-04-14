package net.slimediamond.dragonfly.api.event.listener;

/**
 * An object which can listen for events from dragonfly
 *
 * @see net.slimediamond.dragonfly.api.event.Event
 */
public interface DragonflyListener {
    default void onUpdate() {}
}
