package com.depeng.log.access;

import org.apache.log4j.Logger;

public class Access {



	public static void main(String[] args) {

//		Logger access = Logger.getLogger(Access.class);
		Logger access = Logger.getLogger("access.log");
		access.info("access2 will be only in access.log filedddddddddddddddd info");

	}
}
