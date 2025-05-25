package net.slimediamond.dragonfly.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.slimediamond.data.registry.BasicRegistry;
import net.slimediamond.data.registry.Registry;
import net.slimediamond.dragonfly.api.entity.Entity;
import net.slimediamond.dragonfly.api.entity.EntityType;
import net.slimediamond.dragonfly.api.entity.manager.EntityManager;
import net.slimediamond.dragonfly.api.event.listener.DragonflyListener;
import net.slimediamond.dragonfly.api.input.InputHandler;
import net.slimediamond.dragonfly.api.logger.LoggerWrapper;
import net.slimediamond.dragonfly.api.manager.AbstractManager;
import net.slimediamond.dragonfly.api.maths.time.Time;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.object.GameObject;
import net.slimediamond.dragonfly.api.object.GameObjectType;
import net.slimediamond.dragonfly.api.object.ObjectCreator;
import net.slimediamond.dragonfly.api.object.camera.Camera;
import net.slimediamond.dragonfly.api.object.manager.GameObjectManager;
import net.slimediamond.dragonfly.api.object.text.Text;
import net.slimediamond.dragonfly.api.render.DragonflyRenderContext;
import net.slimediamond.dragonfly.api.render.Graphics;
import net.slimediamond.dragonfly.api.render.RenderContext;
import net.slimediamond.dragonfly.api.render.Renderable;
import net.slimediamond.dragonfly.api.render.Renderer;
import net.slimediamond.dragonfly.api.scheduler.Scheduler;

/**
 * The engine! Vroom vroom.
 *
 * <p>Dragonfly is a game engine for Java.</p>
 *
 * <p>The centralized engine instance, which almost everything goes through
 * in a game, such as spawning {@link GameObject} instances, spawning {@link Entity} instances, rendering {@link Renderable} instances, and the
 * managers for the aforementioned.</p>
 *
 * <h2>Constructing an engine instance</h2>
 * <p>Constructing an engine requires a {@link EngineConfiguration},
 * using {@link EngineConfiguration#builder()} is recommended but technically optional.</p>
 *
 * <pre>{@code
 * DragonflyEngine engine = new DragonflyEngine(EngineConfiguration.builder()
 *     .title("My game!")
 *     .build()
 * );
 * }</pre>
 *
 * <p>Theoretically the above builder needs no arguments, the default parameters are:</p>
 * <ul>
 *     <li>Default title: "Dragonfly Engine"</li>
 *     <li>Default width: 680</li>
 *     <li>Default height: 480</li>
 * </ul>
 *
 * <h2>Lifecycle</h2>
 * <p>The Dragonfly engine has a loop, run on the client thread, which runs the following
 * two methods: {@link #update()} and {@link #render()}</p>
 *
 *
 * <ul>
 *     <li>{@link #initialize()} - initialize the game engine, creating registries, managers, etc</li>
 *     <li>{@link #update()} - handles updating the objects in the game (although not rendering them
 *     just yet)</li>
 *     <li>{@link #render()} - renders all registered {@link GameObject} instances in the
 *     rendering queue using {@link RenderContext}, as given by {@link #update()}</li>
 * </ul>
 *
 * <h2>Object creation</h2>
 * <p>When creating {@link GameObject} instances to be updated and rendered,
 * use {@link #createGameObject(GameObjectType)}.</p>
 *
 * <h2>Threading</h2>
 * <b>Warning:</b>
 * <p>All object spawning should be handled on the client thread. This is done by default
 * in methods such as {@link #createGameObject(GameObjectType)}, but be sure to watch out for it.</p>
 *
 * @see EngineConfiguration
 * @see GameObject
 * @see Registry
 * @see Scheduler
 */
public class DragonflyEngine {

    private final EngineConfiguration configuration;
    private final List<Registry<?>> registries = new LinkedList<>();
    private final List<AbstractManager<?>> managers = new LinkedList<>();
    private final Queue<GameObject> objectsToSpawn = new ConcurrentLinkedQueue<>();
    private final List<Runnable> updateRuns = new LinkedList<>();
    private final List<Runnable> renderRuns = new LinkedList<>();
    private final List<Renderable> renderables = new ArrayList<>();
    private final LoggerWrapper logger = new LoggerWrapper();
    private final Text deltaTimeText = Text.of("DeltaTime not initialized").position(Vector2i.of(5, 15));
    private final Text fpsCounter = Text.of("fps: 0").position(Vector2i.of(5, 30));
    private long lastUpdateTime = System.nanoTime();
    private long lastFrameCountedTime = System.nanoTime();
    private boolean initialized = false;
    private int maxFps = 0;
    private Scheduler scheduler;
    private Renderer renderer;
    private Graphics graphics;
    private InputHandler input;
    private Camera camera;
    private long deltaTime;
    private double fps;

    public DragonflyEngine(EngineConfiguration configuration) {
        this.configuration = configuration;
        this.logger.setLogger(configuration.getLogger());
    }

    /**
     * Initialize the engine, creates frames for the client.
     *
     * <p>This can only be used once - any further attempts to initialize
     * with this instance will return <code>false</code> and do nothing.</p>
     *
     * @return Whether the engine was initialized or not
     */
    public boolean initialize() {
        if (initialized) {
            return false;
        }

        scheduler = new Scheduler(this);

        renderer = configuration.getRenderer();
        renderer.setLogger(logger);

        graphics = renderer.createGraphics();

        input = configuration.getInputHandler();

        scheduler.getClientThread().queue(() -> {
            renderer.init(
                    configuration.getTitle(),
                    configuration.getDefaultWidth(),
                    configuration.getDefaultHeight()
            );

            input.begin(this);

            addRenderable(deltaTimeText);
            addRenderable(fpsCounter);
        });

        scheduler.getClientThread().start();

        GameObjectManager gameObjectManager = new GameObjectManager();
        addManager(gameObjectManager);
        addManager(new EntityManager(gameObjectManager, this));

        addRegistry(new BasicRegistry<>(EntityType.class));
        addRegistry(new BasicRegistry<>(GameObjectType.class));

        camera = new Camera(this);

        scheduler.getClientThread().setRunning(true);

        this.initialized = true;
        logger.debug("Finished initialization");
        return true;
    }

    public void addRegistry(Registry<?> registry) {
        logger.debug("Registering registry type: " + registry.getType().getSimpleName());
        this.registries.add(registry);
    }

    public void addManager(AbstractManager<?> manager) {
        logger.debug("Registering abstract manager: " + manager.getClass().getSimpleName());
        this.managers.add(manager);
    }

    public int getDefaultHeight() {
        return configuration.getDefaultHeight();
    }

    public int getDefaultWidth() {
        return configuration.getDefaultWidth();
    }

    public InputHandler getInput() {
        return input;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public String getTitle() {
        return configuration.getTitle();
    }

    @SuppressWarnings("unchecked")
    public <T> T getRegistry(Class<T> clazz) {
        return (T) registries.stream()
                .filter(registry -> registry.getType().isAssignableFrom(clazz))
                .findFirst().orElse(null);
    }

    @SuppressWarnings("unchecked")
    public <T> T getManager(Class<T> clazz) {
        return (T) managers.stream()
                .filter(manager -> manager.getClass().isAssignableFrom(clazz))
                .findFirst().orElse(null);
    }

    public LoggerWrapper getLogger() {
        return logger;
    }

    public Camera getCamera() {
        return camera;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public EngineConfiguration getConfiguration() {
        return configuration;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public double getFps() {
        return fps;
    }

    public int getMaxFps() {
        return maxFps;
    }

    public void setMaxFps(int maxFps) {
        this.maxFps = maxFps;
    }

    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Update method, which updates game objects.
     *
     * <p>Spawns {@link GameObject}s and their inheritors
     * (like {@link net.slimediamond.dragonfly.api.entity.Entity})</p>
     *
     * <p>This is executed on the client thread.</p>
     *
     * @see #render()
     */
    public void update() {
        long now = System.nanoTime();
        deltaTime = now - lastUpdateTime;
        lastUpdateTime = now;

        deltaTimeText.setContent("Δt: " + getDeltaTime() + "ns");

        GameObject gameObject;
        while ((gameObject = objectsToSpawn.poll()) != null) {
            if (!gameObject.isSpawned()) {
                gameObject.spawn(gameObject.getPosition());
                addRenderable(gameObject);
            }
        }

        // notify all gameobjects of this update
        getManager(GameObjectManager.class).getAll().forEach(DragonflyListener::onUpdate);
        updateRuns.forEach(Runnable::run);
    }

    /**
     * Renders all {@link Renderable} instances in the render queue
     *
     * <p>This should be executed on the client thread.</p>
     *
     * @see #update()
     */
    public void render() {
        fps++;
        if ((System.nanoTime() - lastFrameCountedTime) > 1_000_000_000) {
            fpsCounter.setContent("fps: " + fps);
            fps = 0;
            lastFrameCountedTime = System.nanoTime();
        }

        renderer.clear();

        renderables.forEach(renderable -> {
            RenderContext context = new DragonflyRenderContext(this, graphics, renderable.getRenderPosition());
            renderable.render(context);
        });

        renderer.render();

        // engine.addRenderListener stuff
        renderRuns.forEach(Runnable::run);
    }

    /**
     * Create a {@link GameObject} and submit it for rendering later
     *
     * @param gameObjectType Game object type to create
     * @param <T>            Type of the game object
     * @return The created game object
     */
    @SuppressWarnings("unchecked")
    public <T extends GameObject> T createGameObject(GameObjectType gameObjectType) {
        // When we create a game object, we need to queue it to be shown by the engine
        // So we should add it to the queue (here), and also to the game object manager.

        ObjectCreator<? extends GameObject> creator = gameObjectType.getCreator();

        logger.debug("Creating object '{}'", gameObjectType.getResourceKey().toString());

        T gameObject = (T) creator.create();

        submitGameObject(gameObject);

        return gameObject;
    }

    /**
     * Create a {@link Entity} and submit it for rendering later
     *
     * @param entityType The entity type to create
     * @param <T>        The type of entity
     * @return The created entity
     */
    @SuppressWarnings("unchecked")
    public <T extends Entity> T createEntity(EntityType entityType) {
        ObjectCreator<? extends Entity> creator = entityType.getCreator();

        T entity = (T) creator.create();

        scheduler.getClientThread().queue(() -> {
            logger.debug("Adding entity: '{}'", entity.getEntityType().getResourceKey().toString());
            getManager(EntityManager.class).add(entity);
        });
        submitGameObject(entity);

        return entity;
    }

    private void submitGameObject(GameObject gameObject) {
        scheduler.getClientThread().queue(() -> {
            logger.debug("Adding aforementioned object creation to the queue, type: {}",
                    gameObject.getGameObjectType().getResourceKey().toString());
            getManager(GameObjectManager.class).add(gameObject);
            objectsToSpawn.add(gameObject);
        });
    }

    /**
     * Get the amount of time that has passed since the last {@link #update()}, in <b>nanoseconds</b>.
     *
     * @return Time since last frame update
     */
    public Time getDeltaTime() {
        return Time.ofNanos(deltaTime);
    }

    /**
     * Add a {@link Renderable} to render later in {@link #render()}
     *
     * @param renderable The renderable to add
     */
    public void addRenderable(Renderable renderable) {
        renderables.add(renderable);
        renderables.sort(Comparator.comparing(r -> r instanceof Text ? 1 : 0));
    }

    /**
     * Get the renderables which are going to be rendered
     *
     * @return Renderables
     */
    public List<Renderable> getRenderables() {
        return renderables;
    }

    /**
     * Adds a listener to be called on {@link #update()}
     *
     * @param runnable The runnable to submit
     */
    public void addUpdateListener(Runnable runnable) {
        updateRuns.add(runnable);
    }

    /**
     * Adds a listener to be called on {@link #render()}
     *
     * @param runnable The runnable to submit
     */
    public void addRenderListener(Runnable runnable) {
        renderRuns.add(runnable);
    }

}
