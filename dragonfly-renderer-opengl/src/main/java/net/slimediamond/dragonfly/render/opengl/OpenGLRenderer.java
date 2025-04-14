package net.slimediamond.dragonfly.render.opengl;

import net.slimediamond.dragonfly.api.logger.LoggerWrapper;
import net.slimediamond.dragonfly.api.render.Graphics;
import net.slimediamond.dragonfly.api.render.Renderer;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * The OpenGL renderer implementation for the Dragonfly engine
 */
// I barely know what this does tbh, but it's mostly copied from: https://www.lwjgl.org/guide
// as of April 13, 2025
public class OpenGLRenderer implements Renderer {
    private long window;

    private IntBuffer pWidth;
    private IntBuffer pHeight;

    private LoggerWrapper logger;

    @Override
    public void init(String title, int width, int height) {
        String suffix = " - OpenGL (Dragonfly Engine)";
        GLFWErrorCallback.createPrint(System.err).set();

        if (logger != null) {
            logger.info("Using OpenGL rendering");
        }

        // init GLFW
        if (!glfwInit()) {
            throw new IllegalArgumentException("Could not initialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

        window = glfwCreateWindow(width, height, title + suffix, NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Unable to create GLFW window.");
        }

        try (MemoryStack stack = stackPush()) {
            pWidth = stack.mallocInt(1); // int*
            pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

//            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            // FIXME: works without this, test on other platforms
//            glfwSetWindowPos(
//                    window,
//                    (vidmode.width() - pWidth.get(0)) / 2,
//                    (vidmode.height() - pHeight.get(0)) / 2
//            );

            // Make the OpenGL context current
            glfwMakeContextCurrent(window);

            GL.createCapabilities();

            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); // Enable alpha blending

            updateOrtho(width, height);

            // No vsync
            glfwSwapInterval(0);

            glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

            // Make the window visible
            if (logger != null) {
                logger.info("Showing window!");
            }
            glfwShowWindow(window);
        }
    }

    private void updateOrtho(int width, int height) {
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    @Override
    public void clear() {
        updateWidthHeight();
        updateOrtho(pWidth.get(), pHeight.get());

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
    }

    @Override
    public void render() {
        glfwSwapBuffers(window); // swap the color buffers

        // Poll for window events. The key callback above will only be
        // invoked during this call.
        glfwPollEvents();
    }

    @Override
    public void stop() {
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    @Override
    public boolean shouldDisplayWindow() {
        return !glfwWindowShouldClose(window);
    }

    @Override
    public int getScreenSizeX() {
        // Object-oriented programming called. They want to tell you about `return`
        pWidth.clear();
        glfwGetWindowSize(window, pWidth, null);
        return pWidth.get();
    }

    @Override
    public int getScreenSizeY() {
        pHeight.clear();
        glfwGetWindowSize(window, null, pHeight);
        return pHeight.get();
    }

    private void updateWidthHeight() {
        pWidth.clear();
        pHeight.clear();

        glfwGetWindowSize(window, pWidth, pHeight);
    }

    @Override
    public Graphics createGraphics() {
        return new OpenGLGraphics();
    }

    @Override
    public void setLogger(LoggerWrapper logger) {
        this.logger = logger;
    }

    public long getWindow() {
        return window;
    }
}
