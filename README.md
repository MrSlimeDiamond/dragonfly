# Dragonfly

Dragonfly is a 2D game engine written in Java.

> [!WARNING]
> Dragonfly is not stable, it is not recommended for use in any serious project.
>
> There are lots of known bugs!

**Index**

* [Concepts](#concepts)
    * [Game Loop](#game-loop)
    * [Centralized DragonflyEngine instance](#centralized-dragonflyengine-instance)
    * [Keys](#keys)
    * [Vectors](#vectors)
    * [Game Object Types](#game-object-types)
    * [Game Objects](#game-objects)
* [Getting Started](#getting-started)
    * [Player Movement](#player-movement)
* [Engine Development](#engine-development)
    * [File Structure](#file-structure)
    * [Developer Environment](#developer-environment)
        * [Data API](#data-api)
        * [Compiling Dragonfly](#compiling-dragonfly)
    * [Note on Code Quality](#note-on-code-quality)

**Platform compatibility**

* [x] Linux
* [ ] Windows
* [ ] MacOS
* [ ] FreeBSD

## Concepts

### Game Loop

The game loop is constantly called to continue updating game objects and rendering new frames.

It is limited by the max fps of the game, defined via `DragonflyEngine#setMaxFps`,
unless the max fps is `0`, in which case it always yields - effectively allowing an unlimited
framerate,
bounded by the system.

Here is a visualization of the game loop:

```
+ update --> render  --> [sleep] --> +
^                                    |
|------------------------------------|
```

### Centralized `DragonflyEngine` instance

Every single game will have a `DragonflyEngine` instance which it creates (see the example below
in "Getting started").

This object is the one-stop-shop for doing almost everything, like spawning game objects, handling rendering, etc

A `DragonflyEngine` instance can be created using an `EngineConfiguration`. See the builder or
example below.

The engine instance will live for the entire game session, and can be started with:

```java
engine.initialize();
```

The above will start the game loop.

### Keys

Dragonfly inherits its data API from [SlimeyData](https://github.com/MrSlimeDiamond/data).
Concepts include: `Key`, `Registry`, etc. Please read the docs for SlimeyData as linked previously.

**Game Objects** can store and use `Key`-based data, for storing data.

```java
public class Keys {
    public static final Key<Value<String>> MY_KEY = Key.from(ResourceKey.of("my_game", "test_key"), String.class);
}

public void showMyKey() {
    gameObject.offer(Keys.MY_KEY, "hello!");
    gameObject.get(Keys.MY_KEY).ifPresent(value -> {
        // Use the value of the key!
        System.out.println(value); // Prints: "hello"
    });
}
```

### Vectors

Vectors exist in two types: `Vector2d` and `Vector2i`.

`Vector2d` stores a 2D position using a **double**, and a `Vector2i` stores
a 2D position using an **integer**.

Example usage:

```java
// has decimal points
Vector2d position = Vector2d.of(10.5 , 16.3);

// no decimal points
Vector2i anotherPosition = Vector2i.of(10, 16);
```

### Game Object Types

Game object types can be used to spawn a certain game object:

```java
engine.spawnGameObject(GameObjectTypes.MY_GAME_OBJECT);
```

You can make a game object type as follows:

```java
public static final GameObjectType MY_GAME_OBJECT = new GameObjectType(ResourceKey.of("my_game", "my_game_object"), MyGameObject::new);
```

Then you would make a `MyGameObject` class, extending `AbstractObject`, or `GameObject` if you want
a raw implementation.

### Game Objects

At its core, a game object is something which can be spawned and rendered ingame.

They are effectively an object which holds a position.

Here is the lifecycle of a game object:

```
spawn --> update --> render
```

`update` and `render` are constantly called for the game object until it is removed from the
manager.

GameObjects may listen to events, such as the aforementioned `update` or `render` events, currently
handled with overrides.

Please reference the below example:

```java
public class MyGameObject extends AbstractGameObject {
    public MyGameObject(DragonflyEngine engine) {
        super(engine, GameObjectTypes.MY_GAME_OBJECT);
    }

    @Override
    public Texture getTexture() {
        // This makes a blank square
        return null;
    }

    @Override
    public Vector2i getSize() {
        // In-game size: 50x50
        return Vector2i.of(50, 50);
    }
    
    @Override
    public void onUpdate() {
        // Update logic
    }
}
```

## Getting started

Create a `DragonflyEngine` instance by constructing an engine using the
`EngineConfiguration.Builder`.

```java
public class Client {
    public void start() {
        DragonflyEngine engine = new DragonflyEngine(EngineConfiguration.builder()
                .title("My game!") // title defaults to "Dragonfly Engine"
                .width(680)        // this is the default
                .height(480)       // this is the default
                .renderer(new OpenGLRenderer())
                .inputHandler(new GlfwInputHandler())
                .logger(new Log4jLogger(LogManager.getLogger("dragonfly"))) // This is optional, but recommended.
                .build()
        );

        // Go, go, go!
        engine.initialize();
        
        // Now game objects can be spawned.
    }
}

public class Main {
    public static void main(final String[] args) {
        Client client = new Client();
        client.start();
    }
}
```

### Player movement?

Here is an example `Player` class:

```java
package net.slimediamond.game;

import net.slimediamond.dragonfly.api.DragonflyEngine;
import net.slimediamond.dragonfly.api.data.ResourcePath;
import net.slimediamond.dragonfly.api.data.texture.Texture;
import net.slimediamond.dragonfly.api.event.engine.UpdateEvent;
import net.slimediamond.dragonfly.api.event.listener.Listener;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.AbstractGameObject;
import net.slimediamond.game.data.types.GameObjectTypes;

public class Player extends AbstractGameObject {
    private static final float acceleration = 75f;
    private final DragonflyEngine engine;

    public Player(DragonflyEngine engine) {
        super(engine, GameObjectTypes.PLAYER);
        this.engine = engine;
    }

    @Override
    public Texture getTexture() {
        // This can be null, in which case it'll just be a square
        // `ResourcePath.asset` gets its path from `resources/assets/<path>`
        // `ResurcePath.of` will be a direct reference to `resources/<path>`
        return Texture.withPath(ResourcePath.asset("player.png"));
    }

    @Listener
    public void onUpdate(UpdateEvent event) {
        double deltaTime = engine.getDeltaTime().getSeconds();
        double delta = acceleration * deltaTime;
        Vector2d pos = getPosition();

        Vector2d direction = engine.getInput().get2D().getMovementAxis();

        if (!direction.equals(Vector2d.ZERO)) {
            setPosition(Vector2d.of(
                    pos.getX() + direction.getX() * delta,
                    pos.getY() + direction.getY() * delta
            ));
        }
    }

    @Override
    public Vector2i getSize() {
        return Vector2i.of(50, 50);
    }
}
```

## Engine Development

### File Structure

* `dragonfly-input-glfw/` - Input library for GLFW bindings
* `dragonfly-logger-log4j/` - Logging implementation for log4J
* `dragonfly-renderer-opengl/` - OpenGL renderer
* `src/` - Actual API/source files

### Developer Environment

If you actually want to develop [with] Dragonfly, you'll need to do some messing around since I can'
t be bothered
adding an ever-evolving API to a repository just yet (:

#### Data API

Clone the data API from [here](https://github.com/MrSlimeDiamond/data), and add it to you local
repository with:

```
gradle publishToMavenLocal
```

Then, you should be able to compile the project

#### Compiling Dragonfly

You should easily be able to compile Dragonfly with:

```
gradle build
```

Then it can be included in your project (somehow. Huh, didn't think about that.)

### Note on Code Quality

I've never written a game engine, or even played with graphics that much in Java! This has been a
great
learning experience.

Please give me feedback on anything you think is bad in the project! :)

By the way, this is a hobby project. If I suddenly disappear, don't come looking for me.

**Areas for improvement**:

* **OpenGL renderer**: This is black magic, I have no idea what is going on here. Why is it so hard
  to render a string?
  Please anyone send help, I'm so lost.
    * Vulkan?????
* **Organization**: I have a tendency to...overcomplicate things, possibly evidenced by many ways
  this engine operates
  (but I'm not sure because I made it). Critiques are welcome (and encouraged) - nobody learns by
  doing nothing.
* **Documentation**: Whilst I *think* I've done a good job with documentation, some areas are
  lacking, and are also
  possibly not well written, so anyone who thinks they can update the docs is welcome to!