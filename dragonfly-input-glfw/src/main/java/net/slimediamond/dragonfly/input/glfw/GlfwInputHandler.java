package net.slimediamond.dragonfly.input.glfw;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;
import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

import java.util.HashSet;
import java.util.Set;
import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.input.InputHandler;
import net.slimediamond.dragonfly.render.opengl.OpenGLRenderer;
import org.lwjgl.glfw.GLFWKeyCallback;

public class GlfwInputHandler extends InputHandler {

    private final Set<Integer> heldKeys = new HashSet<>();

    @Override
    public boolean isKeyDown(Integer key) {
        return heldKeys.contains(key);
    }

    @Override
    public void begin(DragonflyEngine engine) {
        if (engine.getRenderer() instanceof OpenGLRenderer renderer) {
            glfwSetKeyCallback(renderer.getWindow(), new GLFWKeyCallback() {
                @Override
                public void invoke(long window, int key, int scancode, int action, int mods) {
                    if (action == GLFW_PRESS) {
                        heldKeys.add(key);
                    } else if (action == GLFW_RELEASE) {
                        heldKeys.remove(key);
                    }
                }
            });
        }
    }

}
