package net.slimediamond.dragonfly.api.object.text;

import java.awt.Font;
import javax.swing.JLabel;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.render.Colors;
import net.slimediamond.dragonfly.api.render.RenderContext;
import net.slimediamond.dragonfly.api.render.Renderable;

/**
 * Text which can be rendered ingame
 *
 * <p>Usage:</p>
 * <pre>{@code
 * Text text = Text.of("Hello world");
 * }</pre>
 *
 * <p>Additionally, text may have a position set on screen,
 * which can be made via a builder-style method</p>
 * <pre>{@code
 * Text.of("hello world").position(Vector2i.of(20, 20));
 * }</pre>
 *
 * @see #of(String content)
 */
public class Text implements Renderable {

    private String content;
    private Vector2i position = Vector2i.of(5, 10);

    private Text(String content) {
        this.content = content;
    }

    /**
     * The {@link Text} factory
     *
     * @param content Content of the text
     * @return Resultant text instance
     */
    public static Text of(String content) {
        return new Text(content);
    }

    /**
     * Get the content of this text
     *
     * @return Text content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set the content of this text
     *
     * @param content Content to set it to
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Vector2i getRenderPosition() {
        return position;
    }

    public Text position(Vector2i position) {
        this.position = position;
        return this;
    }

    public Text content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public void render(RenderContext context) {
        Vector2i pos = context.getRenderPosition();
        Font font = new JLabel().getFont(); // lol
        context.getGraphics().drawString(content, font, pos.getX(), pos.getY(), Colors.BLACK);
    }

    @Override
    public String toString() {
        return "Text{content=" + content + ",position=" + position + "}";
    }

}
