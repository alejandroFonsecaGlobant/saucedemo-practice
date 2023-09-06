package com.globant;

import org.slf4j.LoggerFactory;

public class Reporter {
    private static org.slf4j.Logger getLogger(){
        return LoggerFactory.getLogger(Reporter.class);
    }
    /**
     *Prints INFO level message
     *
     * @param text Text to be printed
     */
    public static void logInfo(String text) {
        getLogger().info(text);
    }


    /**
     *Prints ERROR level message
     *
     * @param text Text to be printed
     */
    public static void logError(String text) {
        getLogger().error(text);
    }

    /**
     *Prints WARNING level message
     *
     * @param text Text to be printed
     */
    public static void logWarning(String text) {
        getLogger().warn(text);
    }
}
