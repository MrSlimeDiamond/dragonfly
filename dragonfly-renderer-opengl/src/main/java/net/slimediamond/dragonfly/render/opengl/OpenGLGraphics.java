package net.slimediamond.dragonfly.render.opengl;

import net.slimediamond.dragonfly.api.data.texture.Texture;
import net.slimediamond.dragonfly.api.render.Color;
import net.slimediamond.dragonfly.api.render.Graphics;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_RGBA8;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDeleteTextures;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glPolygonMode;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;
import static org.lwjgl.system.MemoryStack.stackPush;

public class OpenGLGraphics implements Graphics {

    private Map<String, Integer> textureIds = new HashMap<>();

    @Override
    public void drawRect(int x, int y, int width, int height, Color color) {
        GL11.glColor3i(color.getRed(), color.getGreen(), color.getBlue());

        glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
        glBegin(GL_QUADS);
        glVertex2i(x, y);
        glVertex2i(x + width, y);
        glVertex2i(x + width, y + height);
        glVertex2i(x, y + height);
        glEnd();
        glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
    }

    @Override
    public void fillRect(int x, int y, int width, int height, Color color) {
        GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());

        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    @Override
    public void drawTexture(Texture texture, int x, int y, int width, int height) {
        glEnable(GL_TEXTURE_2D);
		try {
			glBindTexture(GL_TEXTURE_2D, loadTexture(Paths.get(texture.getResourcePath().getUrl().toURI()).toString()));
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

        glBegin(GL_QUADS);
        glTexCoord2f(0, 0); glVertex2i(x, y);
        glTexCoord2f(1, 0); glVertex2i(x + width, y);
        glTexCoord2f(1, 1); glVertex2i(x + width, y + height);
        glTexCoord2f(0, 1); glVertex2i(x, y + height);
        glEnd();

        glDisable(GL_TEXTURE_2D);
    }

    @Override
    public void drawString(String content, Font font, int xPos, int yPos, Color color) {
        FontRenderContext frc = new FontRenderContext(null, true, true);
        Rectangle2D bounds = font.getStringBounds(content, frc);

        int width = (int) Math.ceil(bounds.getWidth());
        int height = (int) Math.ceil(bounds.getHeight());

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(font);
        g.setColor(new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue()));
        g.drawString(content, 0, font.getSize());  // draw at image baseline
        g.dispose();

        int[] pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);

        ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * 4);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = pixels[y * width + x];
                buffer.put((byte) ((pixel >> 16) & 0xFF));  // Red
                buffer.put((byte) ((pixel >> 8) & 0xFF));   // Green
                buffer.put((byte) (pixel & 0xFF));          // Blue
                buffer.put((byte) ((pixel >> 24) & 0xFF));  // Alpha
            }
        }
        buffer.flip();

        int texID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texID);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

        // Render quad at xPos, yPos
        glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, texID);

        glBegin(GL_QUADS);
        glTexCoord2f(0, 0); glVertex2f(xPos, yPos);
        glTexCoord2f(1, 0); glVertex2f(xPos + width, yPos);
        glTexCoord2f(1, 1); glVertex2f(xPos + width, yPos + height);
        glTexCoord2f(0, 1); glVertex2f(xPos, yPos + height);
        glEnd();

        glDeleteTextures(texID);
    }

    public int loadTexture(String path) {
        if (textureIds.containsKey(path)) {
            return textureIds.get(path);
        }

        int[] width = new int[1], height = new int[1], channels = new int[1];

        try (MemoryStack stack = stackPush()) {
            ByteBuffer image = STBImage.stbi_load(path, width, height, channels, 0);
            if (image == null) {
                throw new RuntimeException("Failed to load texture. Path: " + path);
            }

            int textureID = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, textureID);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width[0], height[0], 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
            glGenerateMipmap(GL_TEXTURE_2D);

            STBImage.stbi_image_free(image);

            textureIds.put(path, textureID);

            return textureID;
        }
    }
}
