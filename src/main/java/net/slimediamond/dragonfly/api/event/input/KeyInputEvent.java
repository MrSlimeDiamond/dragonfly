package net.slimediamond.dragonfly.api.event.input;

import net.slimediamond.dragonfly.api.event.AbstractEvent;

public class KeyInputEvent extends AbstractEvent {

    private final int key;

    public KeyInputEvent(int key) {
        this.key = key;
    }

    /**
     * Get the key which was pressed
     *
     * @return Key pressed
     */
    public int getKey() {
        return key;
    }

    public static class Down extends KeyInputEvent {

        public Down(int key) {
            super(key);
        }

    }

    public static class Up extends KeyInputEvent {

        public Up(int key) {
            super(key);
        }

    }

}
