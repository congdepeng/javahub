package com.depeng.log;


import org.apache.log4j.Logger;
import org.junit.Test;

public class LoggerTest {

	Logger logger = Logger.getLogger("Failover");

	@Test
	public void testName() throws Exception {

//		logger.trace("enter app");

		System.out.println("sout");
		System.out.println("sout");
		System.out.println("sout");
		logger.info("print info");

		Logger.getLogger("1").info("1");
		Logger.getLogger("2").info("2");
		Logger.getLogger("3").info("3");
		Logger.getLogger("4").info("4");

	}
}
