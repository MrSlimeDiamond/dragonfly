package net.slimediamond.dragonfly.api.logger;

/**
 * A logger for Dragonfly to use
 */
public interface Logger {

    void catching(Throwable throwable);

    void debug(CharSequence message);

    void debug(CharSequence message, Throwable throwable);

    void debug(Object message);

    void debug(Object message, Throwable throwable);

    void debug(String message);

    void debug(String message, Object... params);

    void debug(String message, Throwable throwable);

    void debug(String message, Object p0);

    void debug(String message, Object p0, Object p1);

    void debug(String message, Object p0, Object p1, Object p2);

    void debug(String message, Object p0, Object p1, Object p2, Object p3);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);

    /** @deprecated */
    @Deprecated
    void entry();

    /** @deprecated */
    @Deprecated
    void entry(Object... params);

    void error(CharSequence message);

    void error(CharSequence message, Throwable throwable);

    void error(Object message);

    void error(Object message, Throwable throwable);

    void error(String message);

    void error(String message, Object... params);

    void error(String message, Throwable throwable);

    void error(String message, Object p0);

    void error(String message, Object p0, Object p1);

    void error(String message, Object p0, Object p1, Object p2);

    void error(String message, Object p0, Object p1, Object p2, Object p3);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);

    /** @deprecated */
    @Deprecated
    void exit();

    /** @deprecated */
    @Deprecated
    <R> R exit(R result);

    void fatal(CharSequence message);

    void fatal(CharSequence message, Throwable throwable);

    void fatal(Object message);

    void fatal(Object message, Throwable throwable);

    void fatal(String message);

    void fatal(String message, Object... params);

    void fatal(String message, Throwable throwable);

    void fatal(String message, Object p0);

    void fatal(String message, Object p0, Object p1);

    void fatal(String message, Object p0, Object p1, Object p2);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);

    String getName();

    void info(CharSequence message);

    void info(CharSequence message, Throwable throwable);

    void info(Object message);

    void info(Object message, Throwable throwable);

    void info(String message);

    void info(String message, Object... params);

    void info(String message, Throwable throwable);
    void info(String message, Object p0);

    void info(String message, Object p0, Object p1);

    void info(String message, Object p0, Object p1, Object p2);

    void info(String message, Object p0, Object p1, Object p2, Object p3);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isFatalEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    <T extends Throwable> T throwing(T throwable);

    void trace(CharSequence message);

    void trace(CharSequence message, Throwable throwable);

    void trace(Object message);

    void trace(Object message, Throwable throwable);

    void trace(String message);

    void trace(String message, Object... params);

    void trace(String message, Throwable throwable);

    void trace(String message, Object p0);

    void trace(String message, Object p0, Object p1);

    void trace(String message, Object p0, Object p1, Object p2);

    void trace(String message, Object p0, Object p1, Object p2, Object p3);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);

    void traceExit();

    <R> R traceExit(R result);

    <R> R traceExit(String format, R result);

    void warn(CharSequence message);

    void warn(CharSequence message, Throwable throwable);

    void warn(Object message);

    void warn(Object message, Throwable throwable);

    void warn(String message);

    void warn(String message, Object... params);

    void warn(String message, Throwable throwable);

    void warn(String message, Object p0);

    void warn(String message, Object p0, Object p1);

    void warn(String message, Object p0, Object p1, Object p2);

    void warn(String message, Object p0, Object p1, Object p2, Object p3);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8);

    void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9);
}
