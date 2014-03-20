package com.depeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloLog.class);
        logger.info("hhhhhhhhhhh");
        logger.error("error~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        logger.warn("warn");
        System.out.println("out");
        System.err.println("error");


// if not config file, print below info
//        SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
//        SLF4J: Defaulting to no-operation (NOP) logger implementation
//        SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.


    }
}

