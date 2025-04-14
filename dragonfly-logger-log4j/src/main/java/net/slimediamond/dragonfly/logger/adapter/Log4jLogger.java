package net.slimediamond.dragonfly.logger.adapter;

import net.slimediamond.dragonfly.api.logger.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogBuilder;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.EntryMessage;
import org.apache.logging.log4j.message.FlowMessageFactory;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

public class Log4jLogger implements Logger {
    private final org.apache.logging.log4j.Logger logger;

    public Log4jLogger(org.apache.logging.log4j.Logger logger) {
        this.logger = logger;
    }

    public void catching(Level level, Throwable throwable) {
        logger.catching(level, throwable);
    }

    @Override
    public void catching(Throwable throwable) {
        logger.catching(throwable);
    }

    public void debug(Marker marker, Message message) {
        logger.debug(marker, message);
    }

    public void debug(Marker marker, Message message, Throwable throwable) {
        logger.debug(marker, message, throwable);
    }

    public void debug(Marker marker, MessageSupplier messageSupplier) {
        logger.debug(marker, messageSupplier);
    }

    public void debug(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.debug(marker, messageSupplier, throwable);
    }

    public void debug(Marker marker, CharSequence message) {
        logger.debug(marker, message);
    }

    public void debug(Marker marker, CharSequence message, Throwable throwable) {
        logger.debug(marker, message, throwable);
    }

    public void debug(Marker marker, Object message) {
        logger.debug(marker, message);
    }

    public void debug(Marker marker, Object message, Throwable throwable) {
        logger.debug(marker, message, throwable);
    }

    public void debug(Marker marker, String message) {
        logger.debug(marker, message);
    }

    public void debug(Marker marker, String message, Object... params) {
        logger.debug(marker, message, params);
    }

    public void debug(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.debug(marker, message, paramSuppliers);
    }

    public void debug(Marker marker, String message, Throwable throwable) {
        logger.debug(marker, message, throwable);
    }

    public void debug(Marker marker, Supplier<?> messageSupplier) {
        logger.debug(marker, messageSupplier);
    }

    public void debug(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.debug(marker, messageSupplier, throwable);
    }

    public void debug(Message message) {
        logger.debug(message);
    }

    public void debug(Message message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    public void debug(MessageSupplier messageSupplier) {
        logger.debug(messageSupplier);
    }

    public void debug(MessageSupplier messageSupplier, Throwable throwable) {
        logger.debug(messageSupplier, throwable);
    }

    @Override
    public void debug(CharSequence message) {
        logger.debug(message);
    }

    @Override
    public void debug(CharSequence message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    @Override
    public void debug(Object message) {
        logger.debug(message);
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Object... params) {
        logger.debug(message, params);
    }

    public void debug(String message, Supplier<?>... paramSuppliers) {
        logger.debug(message, paramSuppliers);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }

    public void debug(Supplier<?> messageSupplier) {
        logger.debug(messageSupplier);
    }

    public void debug(Supplier<?> messageSupplier, Throwable throwable) {
        logger.debug(messageSupplier, throwable);
    }

    public void debug(Marker marker, String message, Object p0) {
        logger.debug(marker, message, p0);
    }

    public void debug(Marker marker, String message, Object p0, Object p1) {
        logger.debug(marker, message, p0, p1);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.debug(marker, message, p0, p1, p2);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.debug(marker, message, p0, p1, p2, p3);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.debug(marker, message, p0, p1, p2, p3, p4);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.debug(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.debug(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.debug(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void debug(String message, Object p0) {
        logger.debug(message, p0);
    }

    @Override
    public void debug(String message, Object p0, Object p1) {
        logger.debug(message, p0, p1);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2) {
        logger.debug(message, p0, p1, p2);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.debug(message, p0, p1, p2, p3);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.debug(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.debug(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.debug(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.debug(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Deprecated
    @Override
    public void entry() {
        logger.entry();
    }

    @Deprecated
    @Override
    public void entry(Object... params) {
        logger.entry(params);
    }

    public void error(Marker marker, Message message) {
        logger.error(marker, message);
    }

    public void error(Marker marker, Message message, Throwable throwable) {
        logger.error(marker, message, throwable);
    }

    public void error(Marker marker, MessageSupplier messageSupplier) {
        logger.error(marker, messageSupplier);
    }

    public void error(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.error(marker, messageSupplier, throwable);
    }

    public void error(Marker marker, CharSequence message) {
        logger.error(marker, message);
    }

    public void error(Marker marker, CharSequence message, Throwable throwable) {
        logger.error(marker, message, throwable);
    }

    public void error(Marker marker, Object message) {
        logger.error(marker, message);
    }

    public void error(Marker marker, Object message, Throwable throwable) {
        logger.error(marker, message, throwable);
    }

    public void error(Marker marker, String message) {
        logger.error(marker, message);
    }

    public void error(Marker marker, String message, Object... params) {
        logger.error(marker, message, params);
    }

    public void error(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.error(marker, message, paramSuppliers);
    }

    public void error(Marker marker, String message, Throwable throwable) {
        logger.error(marker, message, throwable);
    }

    public void error(Marker marker, Supplier<?> messageSupplier) {
        logger.error(marker, messageSupplier);
    }

    public void error(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.error(marker, messageSupplier, throwable);
    }

    public void error(Message message) {
        logger.error(message);
    }

    public void error(Message message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void error(MessageSupplier messageSupplier) {
        logger.error(messageSupplier);
    }

    public void error(MessageSupplier messageSupplier, Throwable throwable) {
        logger.error(messageSupplier, throwable);
    }

    @Override
    public void error(CharSequence message) {
        logger.error(message);
    }

    @Override
    public void error(CharSequence message, Throwable throwable) {
        logger.error(message, throwable);
    }

    @Override
    public void error(Object message) {
        logger.error(message);
    }

    @Override
    public void error(Object message, Throwable throwable) {
        logger.error(message, throwable);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Object... params) {
        logger.error(message, params);
    }

    public void error(String message, Supplier<?>... paramSuppliers) {
        logger.error(message, paramSuppliers);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public void error(Supplier<?> messageSupplier) {
        logger.error(messageSupplier);
    }

    public void error(Supplier<?> messageSupplier, Throwable throwable) {
        logger.error(messageSupplier, throwable);
    }

    public void error(Marker marker, String message, Object p0) {
        logger.error(marker, message, p0);
    }

    public void error(Marker marker, String message, Object p0, Object p1) {
        logger.error(marker, message, p0, p1);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.error(marker, message, p0, p1, p2);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.error(marker, message, p0, p1, p2, p3);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.error(marker, message, p0, p1, p2, p3, p4);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.error(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.error(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.error(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void error(String message, Object p0) {
        logger.error(message, p0);
    }

    @Override
    public void error(String message, Object p0, Object p1) {
        logger.error(message, p0, p1);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2) {
        logger.error(message, p0, p1, p2);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.error(message, p0, p1, p2, p3);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.error(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.error(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.error(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.error(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Deprecated
    @Override
    public void exit() {
        logger.exit();
    }

    @Deprecated
    @Override
    public <R> R exit(R result) {
        return logger.exit(result);
    }

    public void fatal(Marker marker, Message message) {
        logger.fatal(marker, message);
    }

    public void fatal(Marker marker, Message message, Throwable throwable) {
        logger.fatal(marker, message, throwable);
    }

    public void fatal(Marker marker, MessageSupplier messageSupplier) {
        logger.fatal(marker, messageSupplier);
    }

    public void fatal(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.fatal(marker, messageSupplier, throwable);
    }

    public void fatal(Marker marker, CharSequence message) {
        logger.fatal(marker, message);
    }

    public void fatal(Marker marker, CharSequence message, Throwable throwable) {
        logger.fatal(marker, message, throwable);
    }

    public void fatal(Marker marker, Object message) {
        logger.fatal(marker, message);
    }

    public void fatal(Marker marker, Object message, Throwable throwable) {
        logger.fatal(marker, message, throwable);
    }

    public void fatal(Marker marker, String message) {
        logger.fatal(marker, message);
    }

    public void fatal(Marker marker, String message, Object... params) {
        logger.fatal(marker, message, params);
    }

    public void fatal(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.fatal(marker, message, paramSuppliers);
    }

    public void fatal(Marker marker, String message, Throwable throwable) {
        logger.fatal(marker, message, throwable);
    }

    public void fatal(Marker marker, Supplier<?> messageSupplier) {
        logger.fatal(marker, messageSupplier);
    }

    public void fatal(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.fatal(marker, messageSupplier, throwable);
    }

    public void fatal(Message message) {
        logger.fatal(message);
    }

    public void fatal(Message message, Throwable throwable) {
        logger.fatal(message, throwable);
    }

    public void fatal(MessageSupplier messageSupplier) {
        logger.fatal(messageSupplier);
    }

    public void fatal(MessageSupplier messageSupplier, Throwable throwable) {
        logger.fatal(messageSupplier, throwable);
    }

    @Override
    public void fatal(CharSequence message) {
        logger.fatal(message);
    }

    @Override
    public void fatal(CharSequence message, Throwable throwable) {
        logger.fatal(message, throwable);
    }

    @Override
    public void fatal(Object message) {
        logger.fatal(message);
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        logger.fatal(message, throwable);
    }

    @Override
    public void fatal(String message) {
        logger.fatal(message);
    }

    @Override
    public void fatal(String message, Object... params) {
        logger.fatal(message, params);
    }

    public void fatal(String message, Supplier<?>... paramSuppliers) {
        logger.fatal(message, paramSuppliers);
    }

    @Override
    public void fatal(String message, Throwable throwable) {
        logger.fatal(message, throwable);
    }

    public void fatal(Supplier<?> messageSupplier) {
        logger.fatal(messageSupplier);
    }

    public void fatal(Supplier<?> messageSupplier, Throwable throwable) {
        logger.fatal(messageSupplier, throwable);
    }

    public void fatal(Marker marker, String message, Object p0) {
        logger.fatal(marker, message, p0);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1) {
        logger.fatal(marker, message, p0, p1);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.fatal(marker, message, p0, p1, p2);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.fatal(marker, message, p0, p1, p2, p3);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.fatal(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void fatal(String message, Object p0) {
        logger.fatal(message, p0);
    }

    @Override
    public void fatal(String message, Object p0, Object p1) {
        logger.fatal(message, p0, p1);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2) {
        logger.fatal(message, p0, p1, p2);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.fatal(message, p0, p1, p2, p3);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.fatal(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.fatal(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.fatal(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.fatal(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public Level getLevel() {
        return logger.getLevel();
    }

    public <MF extends MessageFactory> MF getMessageFactory() {
        return logger.getMessageFactory();
    }

    public FlowMessageFactory getFlowMessageFactory() {
        return logger.getFlowMessageFactory();
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    public void info(Marker marker, Message message) {
        logger.info(marker, message);
    }

    public void info(Marker marker, Message message, Throwable throwable) {
        logger.info(marker, message, throwable);
    }

    public void info(Marker marker, MessageSupplier messageSupplier) {
        logger.info(marker, messageSupplier);
    }

    public void info(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.info(marker, messageSupplier, throwable);
    }

    public void info(Marker marker, CharSequence message) {
        logger.info(marker, message);
    }

    public void info(Marker marker, CharSequence message, Throwable throwable) {
        logger.info(marker, message, throwable);
    }

    public void info(Marker marker, Object message) {
        logger.info(marker, message);
    }

    public void info(Marker marker, Object message, Throwable throwable) {
        logger.info(marker, message, throwable);
    }

    public void info(Marker marker, String message) {
        logger.info(marker, message);
    }

    public void info(Marker marker, String message, Object... params) {
        logger.info(marker, message, params);
    }

    public void info(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.info(marker, message, paramSuppliers);
    }

    public void info(Marker marker, String message, Throwable throwable) {
        logger.info(marker, message, throwable);
    }

    public void info(Marker marker, Supplier<?> messageSupplier) {
        logger.info(marker, messageSupplier);
    }

    public void info(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.info(marker, messageSupplier, throwable);
    }

    public void info(Message message) {
        logger.info(message);
    }

    public void info(Message message, Throwable throwable) {
        logger.info(message, throwable);
    }

    public void info(MessageSupplier messageSupplier) {
        logger.info(messageSupplier);
    }

    public void info(MessageSupplier messageSupplier, Throwable throwable) {
        logger.info(messageSupplier, throwable);
    }

    @Override
    public void info(CharSequence message) {
        logger.info(message);
    }

    @Override
    public void info(CharSequence message, Throwable throwable) {
        logger.info(message, throwable);
    }

    @Override
    public void info(Object message) {
        logger.info(message);
    }

    @Override
    public void info(Object message, Throwable throwable) {
        logger.info(message, throwable);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Object... params) {
        logger.info(message, params);
    }

    public void info(String message, Supplier<?>... paramSuppliers) {
        logger.info(message, paramSuppliers);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.info(message, throwable);
    }

    public void info(Supplier<?> messageSupplier) {
        logger.info(messageSupplier);
    }

    public void info(Supplier<?> messageSupplier, Throwable throwable) {
        logger.info(messageSupplier, throwable);
    }

    public void info(Marker marker, String message, Object p0) {
        logger.info(marker, message, p0);
    }

    public void info(Marker marker, String message, Object p0, Object p1) {
        logger.info(marker, message, p0, p1);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.info(marker, message, p0, p1, p2);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.info(marker, message, p0, p1, p2, p3);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.info(marker, message, p0, p1, p2, p3, p4);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.info(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.info(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.info(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void info(String message, Object p0) {
        logger.info(message, p0);
    }

    @Override
    public void info(String message, Object p0, Object p1) {
        logger.info(message, p0, p1);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2) {
        logger.info(message, p0, p1, p2);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.info(message, p0, p1, p2, p3);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.info(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.info(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.info(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.info(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    public boolean isEnabled(Level level) {
        return logger.isEnabled(level);
    }

    public boolean isEnabled(Level level, Marker marker) {
        return logger.isEnabled(level, marker);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    public boolean isFatalEnabled(Marker marker) {
        return logger.isFatalEnabled(marker);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    public void log(Level level, Marker marker, Message message) {
        logger.log(level, marker, message);
    }

    public void log(Level level, Marker marker, Message message, Throwable throwable) {
        logger.log(level, marker, message, throwable);
    }

    public void log(Level level, Marker marker, MessageSupplier messageSupplier) {
        logger.log(level, marker, messageSupplier);
    }

    public void log(Level level, Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.log(level, marker, messageSupplier, throwable);
    }

    public void log(Level level, Marker marker, CharSequence message) {
        logger.log(level, marker, message);
    }

    public void log(Level level, Marker marker, CharSequence message, Throwable throwable) {
        logger.log(level, marker, message, throwable);
    }

    public void log(Level level, Marker marker, Object message) {
        logger.log(level, marker, message);
    }

    public void log(Level level, Marker marker, Object message, Throwable throwable) {
        logger.log(level, marker, message, throwable);
    }

    public void log(Level level, Marker marker, String message) {
        logger.log(level, marker, message);
    }

    public void log(Level level, Marker marker, String message, Object... params) {
        logger.log(level, marker, message, params);
    }

    public void log(Level level, Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.log(level, marker, message, paramSuppliers);
    }

    public void log(Level level, Marker marker, String message, Throwable throwable) {
        logger.log(level, marker, message, throwable);
    }

    public void log(Level level, Marker marker, Supplier<?> messageSupplier) {
        logger.log(level, marker, messageSupplier);
    }

    public void log(Level level, Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.log(level, marker, messageSupplier, throwable);
    }

    public void log(Level level, Message message) {
        logger.log(level, message);
    }

    public void log(Level level, Message message, Throwable throwable) {
        logger.log(level, message, throwable);
    }

    public void log(Level level, MessageSupplier messageSupplier) {
        logger.log(level, messageSupplier);
    }

    public void log(Level level, MessageSupplier messageSupplier, Throwable throwable) {
        logger.log(level, messageSupplier, throwable);
    }

    public void log(Level level, CharSequence message) {
        logger.log(level, message);
    }

    public void log(Level level, CharSequence message, Throwable throwable) {
        logger.log(level, message, throwable);
    }

    public void log(Level level, Object message) {
        logger.log(level, message);
    }

    public void log(Level level, Object message, Throwable throwable) {
        logger.log(level, message, throwable);
    }

    public void log(Level level, String message) {
        logger.log(level, message);
    }

    public void log(Level level, String message, Object... params) {
        logger.log(level, message, params);
    }

    public void log(Level level, String message, Supplier<?>... paramSuppliers) {
        logger.log(level, message, paramSuppliers);
    }

    public void log(Level level, String message, Throwable throwable) {
        logger.log(level, message, throwable);
    }

    public void log(Level level, Supplier<?> messageSupplier) {
        logger.log(level, messageSupplier);
    }

    public void log(Level level, Supplier<?> messageSupplier, Throwable throwable) {
        logger.log(level, messageSupplier, throwable);
    }

    public void log(Level level, Marker marker, String message, Object p0) {
        logger.log(level, marker, message, p0);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1) {
        logger.log(level, marker, message, p0, p1);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.log(level, marker, message, p0, p1, p2);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.log(level, marker, message, p0, p1, p2, p3);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.log(level, marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void log(Level level, String message, Object p0) {
        logger.log(level, message, p0);
    }

    public void log(Level level, String message, Object p0, Object p1) {
        logger.log(level, message, p0, p1);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2) {
        logger.log(level, message, p0, p1, p2);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.log(level, message, p0, p1, p2, p3);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.log(level, message, p0, p1, p2, p3, p4);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.log(level, message, p0, p1, p2, p3, p4, p5);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.log(level, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.log(level, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void printf(Level level, Marker marker, String format, Object... params) {
        logger.printf(level, marker, format, params);
    }

    public void printf(Level level, String format, Object... params) {
        logger.printf(level, format, params);
    }

    public <T extends Throwable> T throwing(Level level, T throwable) {
        return logger.throwing(level, throwable);
    }

    @Override
    public <T extends Throwable> T throwing(T throwable) {
        return logger.throwing(throwable);
    }

    public void trace(Marker marker, Message message) {
        logger.trace(marker, message);
    }

    public void trace(Marker marker, Message message, Throwable throwable) {
        logger.trace(marker, message, throwable);
    }

    public void trace(Marker marker, MessageSupplier messageSupplier) {
        logger.trace(marker, messageSupplier);
    }

    public void trace(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.trace(marker, messageSupplier, throwable);
    }

    public void trace(Marker marker, CharSequence message) {
        logger.trace(marker, message);
    }

    public void trace(Marker marker, CharSequence message, Throwable throwable) {
        logger.trace(marker, message, throwable);
    }

    public void trace(Marker marker, Object message) {
        logger.trace(marker, message);
    }

    public void trace(Marker marker, Object message, Throwable throwable) {
        logger.trace(marker, message, throwable);
    }

    public void trace(Marker marker, String message) {
        logger.trace(marker, message);
    }

    public void trace(Marker marker, String message, Object... params) {
        logger.trace(marker, message, params);
    }

    public void trace(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.trace(marker, message, paramSuppliers);
    }

    public void trace(Marker marker, String message, Throwable throwable) {
        logger.trace(marker, message, throwable);
    }

    public void trace(Marker marker, Supplier<?> messageSupplier) {
        logger.trace(marker, messageSupplier);
    }

    public void trace(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.trace(marker, messageSupplier, throwable);
    }

    public void trace(Message message) {
        logger.trace(message);
    }

    public void trace(Message message, Throwable throwable) {
        logger.trace(message, throwable);
    }

    public void trace(MessageSupplier messageSupplier) {
        logger.trace(messageSupplier);
    }

    public void trace(MessageSupplier messageSupplier, Throwable throwable) {
        logger.trace(messageSupplier, throwable);
    }

    @Override
    public void trace(CharSequence message) {
        logger.trace(message);
    }

    @Override
    public void trace(CharSequence message, Throwable throwable) {
        logger.trace(message, throwable);
    }

    @Override
    public void trace(Object message) {
        logger.trace(message);
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        logger.trace(message, throwable);
    }

    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    @Override
    public void trace(String message, Object... params) {
        logger.trace(message, params);
    }

    public void trace(String message, Supplier<?>... paramSuppliers) {
        logger.trace(message, paramSuppliers);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.trace(message, throwable);
    }

    public void trace(Supplier<?> messageSupplier) {
        logger.trace(messageSupplier);
    }

    public void trace(Supplier<?> messageSupplier, Throwable throwable) {
        logger.trace(messageSupplier, throwable);
    }

    public void trace(Marker marker, String message, Object p0) {
        logger.trace(marker, message, p0);
    }

    public void trace(Marker marker, String message, Object p0, Object p1) {
        logger.trace(marker, message, p0, p1);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.trace(marker, message, p0, p1, p2);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.trace(marker, message, p0, p1, p2, p3);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.trace(marker, message, p0, p1, p2, p3, p4);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.trace(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.trace(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.trace(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void trace(String message, Object p0) {
        logger.trace(message, p0);
    }

    @Override
    public void trace(String message, Object p0, Object p1) {
        logger.trace(message, p0, p1);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2) {
        logger.trace(message, p0, p1, p2);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.trace(message, p0, p1, p2, p3);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.trace(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.trace(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.trace(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.trace(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public EntryMessage traceEntry() {
        return logger.traceEntry();
    }

    public EntryMessage traceEntry(String format, Object... params) {
        return logger.traceEntry(format, params);
    }

    public EntryMessage traceEntry(Supplier<?>... paramSuppliers) {
        return logger.traceEntry(paramSuppliers);
    }

    public EntryMessage traceEntry(String format, Supplier<?>... paramSuppliers) {
        return logger.traceEntry(format, paramSuppliers);
    }

    public EntryMessage traceEntry(Message message) {
        return logger.traceEntry(message);
    }

    @Override
    public void traceExit() {
        logger.traceExit();
    }

    @Override
    public <R> R traceExit(R result) {
        return logger.traceExit(result);
    }

    @Override
    public <R> R traceExit(String format, R result) {
        return logger.traceExit(format, result);
    }

    public void traceExit(EntryMessage message) {
        logger.traceExit(message);
    }

    public <R> R traceExit(EntryMessage message, R result) {
        return logger.traceExit(message, result);
    }

    public <R> R traceExit(Message message, R result) {
        return logger.traceExit(message, result);
    }

    public void warn(Marker marker, Message message) {
        logger.warn(marker, message);
    }

    public void warn(Marker marker, Message message, Throwable throwable) {
        logger.warn(marker, message, throwable);
    }

    public void warn(Marker marker, MessageSupplier messageSupplier) {
        logger.warn(marker, messageSupplier);
    }

    public void warn(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {
        logger.warn(marker, messageSupplier, throwable);
    }

    public void warn(Marker marker, CharSequence message) {
        logger.warn(marker, message);
    }

    public void warn(Marker marker, CharSequence message, Throwable throwable) {
        logger.warn(marker, message, throwable);
    }

    public void warn(Marker marker, Object message) {
        logger.warn(marker, message);
    }

    public void warn(Marker marker, Object message, Throwable throwable) {
        logger.warn(marker, message, throwable);
    }

    public void warn(Marker marker, String message) {
        logger.warn(marker, message);
    }

    public void warn(Marker marker, String message, Object... params) {
        logger.warn(marker, message, params);
    }

    public void warn(Marker marker, String message, Supplier<?>... paramSuppliers) {
        logger.warn(marker, message, paramSuppliers);
    }

    public void warn(Marker marker, String message, Throwable throwable) {
        logger.warn(marker, message, throwable);
    }

    public void warn(Marker marker, Supplier<?> messageSupplier) {
        logger.warn(marker, messageSupplier);
    }

    public void warn(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {
        logger.warn(marker, messageSupplier, throwable);
    }

    public void warn(Message message) {
        logger.warn(message);
    }

    public void warn(Message message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    public void warn(MessageSupplier messageSupplier) {
        logger.warn(messageSupplier);
    }

    public void warn(MessageSupplier messageSupplier, Throwable throwable) {
        logger.warn(messageSupplier, throwable);
    }

    @Override
    public void warn(CharSequence message) {
        logger.warn(message);
    }

    @Override
    public void warn(CharSequence message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    @Override
    public void warn(Object message) {
        logger.warn(message);
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Object... params) {
        logger.warn(message, params);
    }

    public void warn(String message, Supplier<?>... paramSuppliers) {
        logger.warn(message, paramSuppliers);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.warn(message, throwable);
    }

    public void warn(Supplier<?> messageSupplier) {
        logger.warn(messageSupplier);
    }

    public void warn(Supplier<?> messageSupplier, Throwable throwable) {
        logger.warn(messageSupplier, throwable);
    }

    public void warn(Marker marker, String message, Object p0) {
        logger.warn(marker, message, p0);
    }

    public void warn(Marker marker, String message, Object p0, Object p1) {
        logger.warn(marker, message, p0, p1);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2) {
        logger.warn(marker, message, p0, p1, p2);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {
        logger.warn(marker, message, p0, p1, p2, p3);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.warn(marker, message, p0, p1, p2, p3, p4);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.warn(marker, message, p0, p1, p2, p3, p4, p5);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.warn(marker, message, p0, p1, p2, p3, p4, p5, p6);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.warn(marker, message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    @Override
    public void warn(String message, Object p0) {
        logger.warn(message, p0);
    }

    @Override
    public void warn(String message, Object p0, Object p1) {
        logger.warn(message, p0, p1);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2) {
        logger.warn(message, p0, p1, p2);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3) {
        logger.warn(message, p0, p1, p2, p3);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {
        logger.warn(message, p0, p1, p2, p3, p4);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {
        logger.warn(message, p0, p1, p2, p3, p4, p5);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {
        logger.warn(message, p0, p1, p2, p3, p4, p5, p6);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {
        logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {
        logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8);
    }

    @Override
    public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {
        logger.warn(message, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9);
    }

    public void logMessage(Level level, Marker marker, String fqcn, StackTraceElement location, Message message, Throwable throwable) {
        logger.logMessage(level, marker, fqcn, location, message, throwable);
    }

    public LogBuilder atTrace() {
        return logger.atTrace();
    }

    public LogBuilder atDebug() {
        return logger.atDebug();
    }

    public LogBuilder atInfo() {
        return logger.atInfo();
    }

    public LogBuilder atWarn() {
        return logger.atWarn();
    }

    public LogBuilder atError() {
        return logger.atError();
    }

    public LogBuilder atFatal() {
        return logger.atFatal();
    }

    public LogBuilder always() {
        return logger.always();
    }

    public LogBuilder atLevel(Level level) {
        return logger.atLevel(level);
    }
}