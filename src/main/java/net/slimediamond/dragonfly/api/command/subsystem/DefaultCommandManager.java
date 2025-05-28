package net.slimediamond.dragonfly.api.command.subsystem;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class DefaultCommandManager implements CommandManager {

    private final List<CommandContainer> commands = new LinkedList<>();

    @Override
    public void registerCommands(Object instance) {
        for (Method method : instance.getClass().getMethods()) {
            if (method.isAnnotationPresent(Command.class)
            && method.getParameters().length == 1
            && method.getParameters()[0].getType().isAssignableFrom(CommandContext.class)) {
                Command metadata = method.getAnnotation(Command.class);
                CommandContainer container = new CommandContainer(metadata, instance, method);
                commands.add(container);
            }
        }
    }

    @Override
    public List<CommandContainer> getCommands() {
        return commands;
    }

}
