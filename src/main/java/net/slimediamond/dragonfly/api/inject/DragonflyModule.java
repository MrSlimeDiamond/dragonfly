package net.slimediamond.dragonfly.api.inject;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import net.slimediamond.dragonfly.api.DragonflyEngine;

public class DragonflyModule extends AbstractModule {

    private final DragonflyEngine engine;

    public DragonflyModule(DragonflyEngine engine) {
        this.engine = engine;
    }

    @Override
    public void configure() {
        bind(DragonflyEngine.class).toProvider(() -> engine).in(Singleton.class);
    }

}
