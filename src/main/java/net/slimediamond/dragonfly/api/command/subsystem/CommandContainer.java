package net.slimediamond.dragonfly.api.command.subsystem;

import java.lang.reflect.Method;

public record CommandContainer(Command metadata, Object instance, Method method) {

}
