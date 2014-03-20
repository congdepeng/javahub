package org;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrgPackage {
        public static void main(String[] args) {
            Logger logger = LoggerFactory.getLogger(OrgPackage.class);
            logger.info("this log will not print into any file, because no root match org package");

        }
}
