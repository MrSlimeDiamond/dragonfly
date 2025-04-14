package net.slimediamond.dragonfly.api.scheduler;

import java.util.LinkedList;
import java.util.List;

/**
 * The asynchronous scheduler for making new threads and running tasks on them.
 */
public class AsyncScheduler {
    private final List<Thread> threads = new LinkedList<>();

    /**
     * Submit something to be run on a new thread
     *
     * <p>Example usage:</p>
     * <pre>
     * engine.getScheduler().getAsyncScheduler().queue(() -> {
     *    // ... (this is async) ...
     * });
     * </pre>
     *
     * @param runnable The runnable to run
     */
    public void submit(Runnable runnable) {
        Thread thread = new Thread(runnable);
        threads.add(thread);

        if (thread.getName() == null) {
            thread.setName("Dragonfly async #" + threads.size());
        }

        thread.start();
    }
}
