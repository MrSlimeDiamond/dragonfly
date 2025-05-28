package net.slimediamond.dragonfly.api.command.subsystem;

import java.util.List;

/**
 * A command manager
 */
public interface CommandManager {

    /**
     * Register {@link Command}-annotated methods in an instance
     *
     * @param instance The instance to register commands for
     */
    void registerCommands(Object instance);

    /**
     * Get the commands which have been registered to this command
     * manager.
     *
     * @return Registered commands
     */
    List<CommandContainer> getCommands();

}
