package net.slimediamond.dragonfly.api.input.keybind;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Static registry for key bindings.
 */
public final class Keybinds {

    public static final String UP = movement("up");
    public static final String DOWN = movement("down");
    public static final String LEFT = movement("left");
    public static final String RIGHT = movement("right");

    private static final Map<Integer, String> defaults = new HashMap<>();
    private static Map<Integer, String> keybinds = new HashMap<>();

    static {
        defaults.put(KeyEvent.VK_W, UP);
        defaults.put(KeyEvent.VK_S, DOWN);
        defaults.put(KeyEvent.VK_A, LEFT);
        defaults.put(KeyEvent.VK_D, RIGHT);
    }

    private static String dragonfly(String... strings) {
        return "dragonfly." + String.join(".", strings);
    }

    public static String movement(String bind) {
        return dragonfly("movement", bind);
    }

    /**
     * Get what bind is associated with a key. May not be present
     *
     * @param key The key to check the bind value of
     * @return The bind, if present, else {@link Optional#empty()}
     */
    public static Optional<String> getBind(int key) {
        return Optional.ofNullable(keybinds.getOrDefault(key, defaults.get(key)));
    }

    /**
     * Return whether a key is associated with a specific bind
     *
     * @param key The key to check
     * @param bind The bind
     * @return Whether they are mapped
     */
    public static boolean isBound(int key, String bind) {
        return getBind(key).isPresent() && getBind(key).get().equalsIgnoreCase(bind);
    }

    /**
     * Get the keys which are associated with a specific bind
     *
     * @param bind The bind to check for
     * @return A list of keys which have that bind
     */
    public static List<Integer> getKeys(String bind) {
        List<Integer> results = keybinds.entrySet().stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase(bind))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            results.addAll(defaults.entrySet().stream()
                    .filter(entry -> entry.getValue().equalsIgnoreCase(bind))
                    .map(Map.Entry::getKey)
                    .toList());
        }
        return results;
    }

    /**
     * Add a default keybind
     *
     * @param key The key to map to
     * @param bind The bind
     */
    public static void addDefault(int key, String bind) {
        defaults.put(key, bind);
    }

    /**
     * Load custom json-formatted keybinds from a file into
     * the registrar.
     *
     * @param configFile The file to load from
     */
    public static void load(File configFile) {
        if (configFile == null) {
            return;
        }
        Gson gson = new Gson();
        if (configFile.exists()) {
            // read from it
            try {
                JsonReader jsonReader = new JsonReader(new FileReader(configFile));
                keybinds = gson.fromJson(jsonReader, new TypeToken<Map<Integer, String>>() {});
            } catch (FileNotFoundException e) {
                // This should literally never happen
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Write the current keybind configuration to the specified file
     *
     * @param configFile The file to write to
     */
    public static void write(File configFile) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Map<Integer, String> keybindMap = new HashMap<>();
        if (keybinds == null) {
            // ???
            keybinds = new HashMap<>();
        }
        if (keybinds.isEmpty()) {
            keybindMap.putAll(defaults);
        } else {
            keybindMap.putAll(keybinds);
        }
        try (FileWriter fileWriter = new FileWriter(configFile)) {
            gson.toJson(keybindMap, new TypeToken<Map<Integer, String>>() {}.getType(), fileWriter);
        }
    }

}
