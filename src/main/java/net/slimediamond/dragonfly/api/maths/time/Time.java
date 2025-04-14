package net.slimediamond.dragonfly.api.maths.time;

/**
 * An immutable reference to a duration of time, allows conversion to
 * lots of different time units, such as seconds, milliseconds, etc.
 *
 * @see #ofNanos(long)
 * @see #ofMillis(long)
 * @see #ofSeconds(double)
 */
public class Time {
    private final long nanos;

    private Time(long nanos) {
        this.nanos = nanos;
    }

    public static Time ofNanos(long nanos) {
        return new Time(nanos);
    }

    public static Time ofMillis(long millis) {
        return new Time(millis * 1_000_000);
    }

    public static Time ofSeconds(double seconds) {
        return new Time((long) (seconds * 1_000_000_000));
    }

    public long getNanos() {
        return nanos;
    }

    public long getMillis() {
        return nanos / 1_000_000;
    }

    public double getSeconds() {
        return nanos / 1_000_000_000.0;
    }

    public Time scaled(double factor) {
        return new Time((long) (nanos * factor));
    }

    @Override
    public String toString() {
        return String.valueOf(getNanos());
    }
}
