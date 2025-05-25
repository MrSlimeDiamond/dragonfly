package net.slimediamond.dragonfly.api.scheduler;

import java.util.ArrayList;
import java.util.List;
import net.slimediamond.dragonfly.api.DragonflyEngine;

/**
 * The main client thread, which the game loop is run on
 */
public class ClientThread extends Thread {

    private final DragonflyEngine engine;
    private final List<Runnable> queue = new ArrayList<>();
    private boolean running = false;

    public ClientThread(DragonflyEngine engine) {
        this.engine = engine;
    }

    @Override
    public void run() {
        engine.getLogger().info("Client thread started");
        executeQueue();

        while (running) {
            long startTime = System.nanoTime();
            if (!engine.getRenderer().shouldDisplayWindow()) {
                engine.getLogger().info("Shutting down!");
                engine.getRenderer().stop();
                setRunning(false);
                break;
            }

            try {
                engine.update();
                engine.render();
                executeQueue();

                if (engine.getMaxFps() == 0) {
                    Thread.yield();
                } else {
                    long frameDuration = 1_000_000_000L / engine.getMaxFps();
                    long elapsed = System.nanoTime() - startTime;
                    long sleepTime = (frameDuration - elapsed) / 1_000_000;

                    if (sleepTime > 1) {
                        Thread.sleep(sleepTime);
                    }

                    // No fucking idea how this works.
                    while (System.nanoTime() - startTime < frameDuration) {
                        Thread.yield();
                    }

                }

            } catch (Exception e) {
                // complain about it, but don't exit the loop
                e.printStackTrace();
                break;
            }
        }
    }

    /**
     * Immediately execute the currently queued runnables
     *
     * <p>
     * <strong>Warning:</strong>
     * This method is for internal use only - do not call this method.
     */
    public void executeQueue() {
        List<Runnable> toRun;
        synchronized (queue) {
            toRun = new ArrayList<>(queue);
            queue.clear();
        }
        for (Runnable runnable : toRun) {
            runnable.run();
        }
    }

    /**
     * Queues a runnable to be run on the client thread when available.
     *
     * @param runnable The runnable to run
     */
    public void queue(Runnable runnable) {
        queue.add(runnable);
    }

    /**
     * Set whether the game loop is running.
     *
     * <p>Setting this to <code>false</code> will effectively stop the game!</p>
     *
     * <p>
     * <strong>Warning:</strong>
     * Probably don't call this!
     * </p>
     *
     * @param running The status to set the game loop to
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

}
