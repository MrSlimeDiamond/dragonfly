package net.slimediamond.dragonfly.api.ui.console;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.text.Text;
import net.slimediamond.dragonfly.api.render.Colors;
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
        Vector2i outerSize = engine.getRenderer().getScreenSize().subtract(Vector2i.of(100, 100));
        Vector2i innerSize = outerSize.subtract(Vector2i.of(20, 20));
        Vector2i position = engine.getCamera().getCenter().asVector2i().subtract(outerSize);
        context.getGraphics().fillRect(position, outerSize);
        context.getGraphics().fillRect(position, innerSize, Colors.DARK_GRAY);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
