package com.witsky.website.web.log;

import org.slf4j.*;

import javax.validation.constraints.NotNull;

/**
 * <p>
 */
public class ControllerLogger {

    private static final ThreadLocal<Logger> LOGGER_THREAD_LOCAL = new ThreadLocal<>();

    static void setLogger(@NotNull Logger logger) {
        LOGGER_THREAD_LOCAL.set(logger);
    }

    static void removeLogger() {
        LOGGER_THREAD_LOCAL.remove();
    }

    public static Logger logger(Class<?> defaultLogger) {
        Logger logger = LOGGER_THREAD_LOCAL.get();
        if (logger != null) {
            return logger;
        }
        return LoggerFactory.getLogger(defaultLogger);
    }

    public static Logger logger(String defaultLogger) {
        Logger logger = LOGGER_THREAD_LOCAL.get();
        if (logger != null) {
            return logger;
        }
        return LoggerFactory.getLogger(defaultLogger);
    }

    public static Logger logger(Logger defaultLogger) {
        Logger logger = LOGGER_THREAD_LOCAL.get();
        if (logger != null) {
            return logger;
        }
        return defaultLogger;
    }

}
