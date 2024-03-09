package com.c4hco.test.automation.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Log {

    // Initialize Log4j instance
    private static Logger Log = LogManager.getLogger(Log.class);

    // Info Level Logs
    public static void info(String message){ Log.info(message); }

}
