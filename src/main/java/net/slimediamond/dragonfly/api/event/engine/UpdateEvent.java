package net.slimediamond.dragonfly.api.event.engine;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.event.AbstractEvent;

public class UpdateEvent extends AbstractEvent {

    private final DragonflyEngine engine;

    public UpdateEvent(DragonflyEngine engine) {
        this.engine = engine;
    }

    public DragonflyEngine getEngine() {
        return engine;
    }

}
