package net.slimediamond.dragonfly.api.ui.console;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.text.Text;
import net.slimediamond.dragonfly.api.render.RenderContext;
import net.slimediamond.dragonfly.api.ui.UserInterface;

public class ConsoleInterface extends UserInterface.Abstract {

    private final DragonflyEngine engine;

    public ConsoleInterface(DragonflyEngine engine) {
        super(Text.of("Console"));

        this.engine = engine;
    }

    @Override
    public void renderUI(RenderContext context) {
        // TODO: Make this a percentage of the screen size
        // ... for now, this is completely fine, assuming we're on a decently modern resolution.
        Vector2i size = engine.getRenderer().getScreenSize().subtract(Vector2i.of(100, 100));
        context.getGraphics().fillRect(Vector2i.of(0, 0), size);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
