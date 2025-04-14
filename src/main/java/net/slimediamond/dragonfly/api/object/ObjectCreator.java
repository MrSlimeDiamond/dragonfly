package net.slimediamond.dragonfly.api.object;

import java.util.function.Supplier;

/**
 * The creator for an object
 *
 * @param <T> The type to create
 */
public interface ObjectCreator<T> {
    /**
     * Create an instance of this object
     *
     * @return The created object instance
     */
    T create();

    /**
     * The {@link ObjectCreator} factory
     *
     * @param supplier Supplier for objects to be created with
     * @return The resultant object creator
     * @param <Z> Type of object creator
     */
    static <Z> ObjectCreator<Z> of(Supplier<Z> supplier) {
        return supplier::get;
    }
}
