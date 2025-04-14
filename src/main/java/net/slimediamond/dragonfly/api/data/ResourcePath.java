package net.slimediamond.dragonfly.api.data;

import java.net.URL;

/**
 * An immutable reference to a resource location (in <code>src/resources</code>)
 *
 * <p>Usage:</p>
 * <pre>
 * ResourcePath resourcePath = ResourcePath.of("path/to/some/file.ext");
 * // or for an asset
 * ResourcePath resourcePath = ResourcePath.asset("something.png");
 * </pre>
 */
public class ResourcePath {
    private final String path;

    private ResourcePath(String path) {
        this.path = path;
    }

    /**
     * The {@link ResourcePath} factory
     *
     * @param path The path of the resource path
     * @return ResourcePath instance
     */
    public static ResourcePath of(String path) {
        return new ResourcePath(path);
    }

    /**
     * The {@link ResourcePath} factory for assets
     *
     * @param path The path of the resource path
     * @return ResourcePath instance
     */
    public static ResourcePath asset(String path) {
        return new ResourcePath("/assets/" + path);
    }

    /**
     * Get this resource path as a string
     *
     * @return Resource path
     */
    public String toString() {
        return path;
    }

    /**
     * Get this as a URL
     *
     * @return URL
     */
    public URL getUrl() {
        return getClass().getResource(path);
    }
}
