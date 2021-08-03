package com.deb.ex.logging_examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogPrint {

    private static final Logger logger = LogManager.getLogger(LogPrint.class);

    public void doThis(String str){

        System.out.println("This is LogPrint");

        logger.trace("This is a TRACE message for {}", str);
        logger.debug("This is a DEBUG message for {}", str);
        logger.info("This is a INFO message for {}", str);
        logger.warn("This is a WARN message for {}", str);
        logger.error("This is a ERROR message for {}", str);
    }

}
