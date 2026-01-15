package dev.basicbot.log_activities;

import java.util.logging.*;
import java.io.IOException;

public class LogManager {
    private static Logger logger;
    private static FileHandler fHandler;

    public static Logger getLogger(){
        if (logger == null) {
            try {
                    // Define the property
                    System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tT] %4$s: %5$s%n");

                    // Define the type of the object
                    logger   = Logger.getLogger("Log");

                    // Delete the previous log and create one
                    fHandler = new FileHandler("Log_execution.log", false);
                    fHandler.setFormatter(new SimpleFormatter());
                    logger.addHandler(fHandler);

                    logger.setUseParentHandlers(false);

            } catch (IOException e) {
                System.err.println("LOG: Error can'create a new log: " + e.getMessage());
            }
        }
        return logger;
    }
}   




