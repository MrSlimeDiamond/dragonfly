package net.slimediamond.dragonfly.api.command.subsystem;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.object.text.Text;

import java.util.List;

public interface CommandContext {

    /**
     * Send a message to the receiver
     *
     * @param message The message to send
     */
    void sendMessage(Text message);

    /**
     * Get the engine which this command stems from
     *
     * @return Engine
     */
    DragonflyEngine getEngine();

    /**
     * Get everything typed <i>after</i> the command name
     *
     * @return Command arguments
     */
    List<String> getArguments();

}
