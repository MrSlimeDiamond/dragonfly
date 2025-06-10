package net.slimediamond.dragonfly.api.ui.console;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.text.Text;
import net.slimediamond.dragonfly.api.render.RenderContext;
import net.slimediamond.dragonfly.api.ui.UserInterface;

public class ConsoleInterface extends UserInterface.Abstract {

    private static final double SCALE = 0.95; // outer box size, 5% minus screen size
    private final DragonflyEngine engine;

    public ConsoleInterface(DragonflyEngine engine) {
        super(Text.of("Console"));  // (This does almost nothing atm lol)

        this.engine = engine;
    }

    @Override
    public void renderUI(RenderContext context) {
        // subtract 5% of the screen size
        final Vector2i size = context.getEngine().getRenderer().getScreenSize().asVector2d().multiply(Vector2d.of(SCALE, SCALE)).asVector2i();
        context.getGraphics().drawRect(context.getRenderPosition(), size);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
