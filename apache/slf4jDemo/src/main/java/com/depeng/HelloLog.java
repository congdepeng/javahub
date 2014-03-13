package com.depeng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloLog {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloLog.class);
        logger.info("hhhhhhhhhhh");


//        if not config file, print below info
//        13:31:15.283 [main] INFO  com.depeng.HelloLog - hhhhhhhhhhh

        // we need a config like  logback.xml或logback-test.xml

    }
}
