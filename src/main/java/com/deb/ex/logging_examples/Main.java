package com.deb.ex.logging_examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * slf4j acts as an abstraction for other logging frameworks
 *
 * log4j has three main components:
 * loggers
 * appenders
 * layouts
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String name = "deba";
        List<String> techList = Arrays.asList("HTML", "Javascript", "CSS", "XML", "JSON",
                "Java", "Spring", "JDBC", "Hibernate", "SQL");

        List<Integer> myList = Arrays.asList(346, 264, 732, 749, 725, 788, 451, 257,
                927, 989);

        techList.forEach(i -> System.out.println(i));

        logger.info("This is a Trace message by {}", name);

    }
}
