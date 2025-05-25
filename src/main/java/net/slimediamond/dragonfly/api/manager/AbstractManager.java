package net.slimediamond.dragonfly.api.manager;

import java.util.ArrayList;
import java.util.List;

/**
 * A manager for some kind of object
 *
 * @param <T> The type to manage
 */
public class AbstractManager<T> {

    private final List<T> objects = new ArrayList<>();

    public List<T> getAll() {
        return objects;
    }

    public void add(T object) {
        objects.add(object);
    }

    public void remove(T object) {
        objects.remove(object);
    }

}
