package net.slimediamond.dragonfly.api.scheduler;

import net.slimediamond.dragonfly.api.DragonflyEngine;

/**
 * The scheduler, which handles the client thread and also async threads
 *
 * @see #getClientThread()
 * @see #getAsyncScheduler()
 */
public class Scheduler {

    private final ClientThread clientThread;
    private final AsyncScheduler asyncScheduler;

    public Scheduler(DragonflyEngine engine) {
        this.clientThread = new ClientThread(engine);
        clientThread.setName("Client thread");

        this.asyncScheduler = new AsyncScheduler();
    }

    /**
     * Gets the client thread
     *
     * @return Client thread
     */
    public ClientThread getClientThread() {
        return clientThread;
    }

    /***
     * Gets the async scheduler
     *
     * @return Async scheduler
     */
    public AsyncScheduler getAsyncScheduler() {
        return asyncScheduler;
    }

}
