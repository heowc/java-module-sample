package com.heowc;

import java.util.logging.Logger;

public class LoggerModule {

    private static final Logger logger = Logger.getLogger(LoggerModule.class.getName());

    public static void main(String[] args) {
        logger.info("Hello World!");
    }
}
