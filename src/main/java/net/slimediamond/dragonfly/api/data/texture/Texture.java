package net.slimediamond.dragonfly.api.data.texture;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.slimediamond.dragonfly.api.data.ResourcePath;

/**
 * A texture which can be attached to something, for it to be rendered
 *
 * @see net.slimediamond.dragonfly.api.render.RenderContext
 * @see TextureHolder
 */
public interface Texture {

    static Texture withPath(ResourcePath resourcePath) {
        return () -> resourcePath;
    }

    /**
     * Get the resource path for this texture
     *
     * @return Texture resource path
     */
    ResourcePath getResourcePath();

    /**
     * Get this texture as an image, for rendering on the frame
     *
     * @return Texture image
     */
    default Image getImage() {
        try {
            return ImageIO.read(getResourcePath().getUrl());
        } catch (IOException e) {
            throw new RuntimeException("Resource path not found", e);
        }
    }

}
