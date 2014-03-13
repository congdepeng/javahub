package com.depeng.log;

//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaClassMain {

	public static void main(String[] args) {

		JavaClassMain javaClassMain = new JavaClassMain();
		javaClassMain.objectMethod();


		New aNew = new New();
		aNew.method();
	}


	public void objectMethod() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("aaaaaaaaaaaaaaaaaaaaaaa");

//        System.out.println("=======================================");
//		Logger.getLogger("1").info("1");
//		Logger.getLogger("2").info("2");
//		Logger.getLogger("3").info("3");
//		Logger.getLogger("4").info("4");
//		Logger.getLogger(OtherClass.class).error("error");

	}

}
