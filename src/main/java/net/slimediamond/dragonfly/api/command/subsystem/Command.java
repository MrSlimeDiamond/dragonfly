package net.slimediamond.dragonfly.api.command.subsystem;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A command which can be used through the console, or on startup.
 *
 * <p>The console can be accessed with the <code>`</code> key by default</p>
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    /**
     * The aliases which the command can be used from
     *
     * @return Command aliases
     */
    String[] aliases();

    /**
     * The description of the command
     *
     * @return Command description
     */
    String description();

    /**
     * Whether using this command requires cheats to be enabled
     *
     * @return Cheats required
     */
    boolean requiresCheats() default false;

}
