package net.slimediamond.dragonfly.api.logger;

/**
 * A wrapper for {@link Logger}, since it could possibly not be initialized by the engine configuration.
 */
public class LoggerWrapper {

    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public void catching(Throwable throwable) {
        if (logger != null) {
            logger.catching(throwable);
        }
    }

    public void debug(CharSequence message) {
        if (logger != null) {
            logger.debug(message);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public boolean isTraceEnabled() {
        if (logger != null) {
            return logger.isTraceEnabled();
        } else {
            return false;
        }
    }

    public void traceExit() {
        if (logger != null) {
            logger.traceExit();
        }
    }

    public void warn(String message) {
        if (logger != null) {
            logger.warn(message);
        }
    }

    public void error(String message, Object... params) {
        if (logger != null) {
            logger.error(message, params);
        }
    }

    public void error(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.error(message, p0, p1);
        }
    }

    public void warn(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.warn(message, p0, p1);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2);
        }
    }

    public void info(String message, Object p0) {
        if (logger != null) {
            logger.info(message, p0);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4);
        }
    }

    public void fatal(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.fatal(message, throwable);
        }
    }

    public void debug(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.debug(message, throwable);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void fatal(Object message, Throwable throwable) {
        if (logger != null) {
            logger.fatal(message, throwable);
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void info(CharSequence message) {
        if (logger != null) {
            logger.info(message);
        }
    }

    public void warn(String message, Object p0) {
        if (logger != null) {
            logger.warn(message, p0);
        }
    }

    @Deprecated
    public <R> R exit(R result) {
        if (logger != null) {
            return logger.exit(result);
        } else {
            return null;
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4);
        }
    }

    public void fatal(Object message) {
        if (logger != null) {
            logger.fatal(message);
        }
    }

    @Deprecated
    public void entry() {
        if (logger != null) {
            logger.entry();
        }
    }

    public void info(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.info(message, p0, p1);
        }
    }

    public void warn(String message, Throwable throwable) {
        if (logger != null) {
            logger.warn(message, throwable);
        }
    }

    public boolean isDebugEnabled() {
        if (logger != null) {
            return logger.isDebugEnabled();
        } else {
            return false;
        }
    }

    public void fatal(CharSequence message) {
        if (logger != null) {
            logger.fatal(message);
        }
    }

    public void info(String message, Throwable throwable) {
        if (logger != null) {
            logger.info(message, throwable);
        }
    }

    public <R> R traceExit(String format, R result) {
        if (logger != null) {
            return logger.traceExit(format, result);
        } else {
            return null;
        }
    }

    public void warn(Object message, Throwable throwable) {
        if (logger != null) {
            logger.warn(message, throwable);
        }
    }

    public boolean isWarnEnabled() {
        if (logger != null) {
            return logger.isWarnEnabled();
        } else {
            return false;
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void debug(Object message) {
        if (logger != null) {
            logger.debug(message);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3);
        }
    }

    public void trace(Object message) {
        if (logger != null) {
            logger.trace(message);
        }
    }

    public void trace(String message, Object p0) {
        if (logger != null) {
            logger.trace(message, p0);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.error(message, p0, p1, p2);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public boolean isInfoEnabled() {
        if (logger != null) {
            return logger.isInfoEnabled();
        } else {
            return false;
        }
    }

    public void info(String message) {
        if (logger != null) {
            logger.info(message);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3);
        }
    }

    public void trace(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.trace(message, p0, p1);
        }
    }

    public void error(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.error(message, throwable);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public String getName() {
        if (logger != null) {
            return logger.getName();
        } else {
            return null;
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public <T extends Throwable> T throwing(T throwable) {
        if (logger != null) {
            return logger.throwing(throwable);
        } else {
            return null;
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.info(message, p0, p1, p2);
        }
    }

    public void error(String message, Throwable throwable) {
        if (logger != null) {
            logger.error(message, throwable);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2);
        }
    }

    public void warn(String message, Object... params) {
        if (logger != null) {
            logger.warn(message, params);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void debug(Object message, Throwable throwable) {
        if (logger != null) {
            logger.debug(message, throwable);
        }
    }

    public void debug(String message) {
        if (logger != null) {
            logger.debug(message);
        }
    }

    public void debug(String message, Object... params) {
        if (logger != null) {
            logger.debug(message, params);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void trace(String message, Throwable throwable) {
        if (logger != null) {
            logger.trace(message, throwable);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4);
        }
    }

    public void warn(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.warn(message, throwable);
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void debug(String message, Throwable throwable) {
        if (logger != null) {
            logger.debug(message, throwable);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void error(Object message) {
        if (logger != null) {
            logger.error(message);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void trace(Object message, Throwable throwable) {
        if (logger != null) {
            logger.trace(message, throwable);
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2);
        }
    }

    public void debug(String message, Object p0) {
        if (logger != null) {
            logger.debug(message, p0);
        }
    }

    public void error(String message, Object p0) {
        if (logger != null) {
            logger.error(message, p0);
        }
    }

    public void fatal(String message, Object... params) {
        if (logger != null) {
            logger.fatal(message, params);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3);
        }
    }

    @Deprecated
    public void exit() {
        if (logger != null) {
            logger.exit();
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3);
        }
    }

    public void trace(CharSequence message) {
        if (logger != null) {
            logger.trace(message);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void fatal(String message, Object p0) {
        if (logger != null) {
            logger.fatal(message, p0);
        }
    }

    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void warn(Object message) {
        if (logger != null) {
            logger.warn(message);
        }

    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public <R> R traceExit(R result) {
        if (logger != null) {
            return logger.traceExit(result);
        } else {
            return null;
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void info(Object message, Throwable throwable) {
        if (logger != null) {
            logger.info(message, throwable);
        }
    }

    public void warn(CharSequence message) {
        if (logger != null) {
            logger.warn(message);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4, p5, p6);
        }
    }

    public void info(String message, Object... params) {
        if (logger != null) {
            logger.info(message, params);
        }
    }

    public void error(CharSequence message) {
        if (logger != null) {
            logger.error(message);
        }
    }

    public void info(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.info(message, throwable);
        }
    }

    public void info(Object message) {
        if (logger != null) {
            logger.info(message);
        }
    }

    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.info(message, p0, p1, p2, p3, p4);
        }
    }

    public void trace(String message, Object... params) {
        if (logger != null) {
            logger.trace(message, params);
        }
    }

    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        if (logger != null) {
            logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4);
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3);
        }
    }

    public void fatal(String message, Throwable throwable) {
        if (logger != null) {
            logger.fatal(message, throwable);
        }
    }

    public void error(Object message, Throwable throwable) {
        if (logger != null) {
            logger.error(message, throwable);
        }
    }

    public void error(String message) {
        if (logger != null) {
            logger.error(message);
        }
    }

    public void trace(String message) {
        if (logger != null) {
            logger.trace(message);
        }
    }

    @Deprecated
    public void entry(Object... params) {
        if (logger != null) {
            logger.entry(params);
        }
    }

    public void debug(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.debug(message, p0, p1);
        }
    }

    public void trace(CharSequence message, Throwable throwable) {
        if (logger != null) {
            logger.trace(message, throwable);
        }
    }

    public boolean isFatalEnabled() {
        if (logger != null) {
            return logger.isFatalEnabled();
        } else {
            return false;
        }
    }

    public void fatal(String message) {
        if (logger != null) {
            logger.fatal(message);
        }
    }

    public void fatal(String message, Object p0, Object p1) {
        if (logger != null) {
            logger.fatal(message, p0, p1);
        }
    }

    public boolean isErrorEnabled() {
        if (logger != null) {
            return logger.isErrorEnabled();
        } else {
            return false;
        }
    }

    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        if (logger != null) {
            logger.fatal(message, p0, p1, p2, p3, p4, p5);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
        }
    }

    public void debug(String message, Object p0, Object p1, Object p2) {
        if (logger != null) {
            logger.debug(message, p0, p1, p2);
        }
    }

}
