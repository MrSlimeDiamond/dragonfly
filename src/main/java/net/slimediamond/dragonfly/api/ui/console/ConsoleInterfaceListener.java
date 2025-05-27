package net.slimediamond.dragonfly.api.ui.console;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.event.input.KeyInputEvent;
import net.slimediamond.dragonfly.api.event.listener.Listener;

public class ConsoleInterfaceListener {

    private static final int KEYBIND = 96;
    private final DragonflyEngine engine;

    public ConsoleInterfaceListener(DragonflyEngine engine) {
        this.engine = engine;
    }

    @Listener
    public void onKeyDown(KeyInputEvent.Down event) {
        if (event.getKey() == KEYBIND) {
            // reverse status
            engine.getConsoleInterface().setVisible(!engine.getConsoleInterface().isVisible());
        }
    }

}
