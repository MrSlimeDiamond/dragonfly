package net.slimediamond.dragonfly.api.command.builtin;

import net.slimediamond.dragonfly.api.command.subsystem.Command;
import net.slimediamond.dragonfly.api.command.subsystem.CommandContext;
import net.slimediamond.dragonfly.api.object.text.Text;

public class DebugCommands {

    @Command(aliases = "show_fps", description = "Whether to show the frames per second (FPS) on-screen")
    public void showFpsCommand(CommandContext context) {
        if (context.getArguments().isEmpty()) {
            context.sendMessage(Text.of("Usage: show_fps <true|false>"));
            return;
        }
        boolean status = Boolean.parseBoolean(context.getArguments().getFirst());
        context.getEngine().setShowFps(status);
    }

    @Command(aliases = "max_fps", description = "Set the highest framerate which the client will render")
    public void fpsMaxCommand(CommandContext context) {
        if (context.getArguments().isEmpty()) {
            context.sendMessage(Text.of("Usage: max_fps <fps>"));
            return;
        }
        int max = Integer.parseInt(context.getArguments().getFirst());
        context.getEngine().setMaxFps(max);
    }

}
