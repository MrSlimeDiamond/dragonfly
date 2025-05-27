package net.slimediamond.dragonfly.api.event;

import net.slimediamond.dragonfly.api.event.listener.Listener;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The event manager, this handles posting events to methods annotated
 * with {@link net.slimediamond.dragonfly.api.event.listener.Listener}
 */
public class EventManager {

    private final List<Object> listeners = new LinkedList<>();

    public void addListener(Object listener) {
        this.listeners.add(listener);
    }

    public void post(Event event) {
        listeners.forEach(instance -> Arrays.stream(instance.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(Listener.class))
                .filter(method -> method.getParameters().length == 1)
                .filter(method -> method.getParameters()[0].getType().isAssignableFrom(event.getClass()))
                .forEach(method -> {
                    try {
                        method.invoke(instance, event);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException("Error firing event " + event.getClass().getName() + " for instance " +
                                instance.getClass().getSimpleName(), e);
                    }
                }));
    }

}
