package com.depeng.log;


import org.apache.log4j.Logger;

public class New {


	static Logger logger = Logger.getLogger(OtherClass.class);

	void method() {
		logger.error("I am New class");
	}







}
