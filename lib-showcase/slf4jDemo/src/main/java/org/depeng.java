package org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class depeng {
        public static void main(String[] args) {
            Logger logger = LoggerFactory.getLogger(depeng.class);
            logger.info("this log will not print into any file, because no root match org package");

        }


//        if not config file, print below info
//        13:31:15.283 [main] INFO  com.depeng.HelloLog - hhhhhhhhhhh

            // we need a config like  logback.xml或logback-test.xml

}
