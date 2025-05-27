package net.slimediamond.dragonfly.api.object;

import net.slimediamond.data.DataHolder;
import net.slimediamond.dragonfly.api.data.texture.TextureHolder;
import net.slimediamond.dragonfly.api.maths.PositionHolder;
import net.slimediamond.dragonfly.api.maths.vector.Vector2d;
import net.slimediamond.dragonfly.api.maths.vector.Vector2i;
import net.slimediamond.dragonfly.api.render.Renderable;

/**
 * An object within the game, which has a position in the 2D space
 *
 * <p>A GameObject is the base for most other things in the game, they are queued
 * into {@link net.slimediamond.dragonfly.api.DragonflyEngine#update()} and then rendered with
 * {@link net.slimediamond.dragonfly.api.DragonflyEngine#render()}</p>
 *
 * <p>Game objects are data holders, which means they can be
 * offered {@link net.slimediamond.data.Key}s for which data may be stored.</p>
 *
 * <p>Game objects also hold textures, and have built-in rendering logic.</p>
 *
 * <p>Creation of a game object should be done via the
 * {@link net.slimediamond.dragonfly.api.DragonflyEngine#createGameObject(GameObjectType)} method.</p>
 *
 * <p>The most basic of game objects can easily be created with:</p>
 * <pre>{@code
 * public class MyGameObjectTypes {
 *     public static final GameObjectType MY_GAME_OBJECT = new GameObjectType(ResourceKey.of("my_game", "my_object"), SomeGameObject::new);
 * }
 *
 * public class SomeGameObject extends AbstractGameObject {
 *     public SomeGameObject() {
 *         super(MyGameObjectTypes.MY_GAME_OBJECT);
 *     }
 * }
 *
 * public class Client {
 *     public void spawnMyGameObject() {
 *         MyGameObject myGameObject = engine.spawnGameObject(MyGameObjectTypes.MY_GAME_OBJECT);
 *         // ...
 *     }
 * }
 * }</pre>
 *
 * @see net.slimediamond.dragonfly.api.DragonflyEngine#createGameObject(GameObjectType)
 * @see net.slimediamond.dragonfly.api.object.manager.GameObjectManager
 * @see GameObjectType
 * @see AbstractGameObject
 */
public interface GameObject extends DataHolder, TextureHolder, Renderable, PositionHolder {

    /**
     * Spawn this game object
     */
    void spawn(Vector2d position);

    /**
     * Get whether this game object has been spawned
     *
     * @return Game object presence
     */
    boolean isSpawned();

    /**
     * Get the position of this entity
     *
     * @return Entity position
     */
    Vector2d getPosition();

    /**
     * Set the position of this entity
     *
     * @param position Position to teleport this entity to
     */
    void setPosition(Vector2d position);

    /**
     * Set the position of this entity
     *
     * @param position Position to teleport this entity to
     */
    void setPosition(Vector2i position);


    /**
     * Get the game object type
     *
     * @return Game object type
     */
    GameObjectType getGameObjectType();

    /**
     * Get the size of this game object
     *
     * @return Game object size
     */
    Vector2i getSize();

    /**
     * Make this game object follow a specified position holder.
     *
     * <p>Each game object can only have <b>one</b> thing which it's following,
     * or otherwise <b>none</b>.</p>
     *
     * @param positionHolder The position holder to follow
     * @see #stopFollowing()
     */
    void setFollowing(PositionHolder positionHolder);

    /**
     * Stop following the {@link PositionHolder} which is currently
     * being followed, if present.
     *
     * @see #setFollowing(PositionHolder)
     */
    void stopFollowing();

    /**
     * Get whether this game object is currently following another gmae object
     *
     * @return Following status
     */
    boolean isFollowing();

}
