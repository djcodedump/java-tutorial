package com.deb.ex.logging_examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * slf4j acts as an abstraction for other logging frameworks
 *
 * log4j has three main components:
 * loggers
 * appenders
 * layouts
 */
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("This is Main");

        String name = "deba";

        logger.info("This is a Info message by {}", name);

        new LogPrint().doThis(name);

    }
}
