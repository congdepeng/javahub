package com.depeng.log;

import org.apache.log4j.Logger;

public class OtherClass {
	int anInt;

	public int getAnInt() {
		return anInt;
	}

	public void setAnInt(int anInt) {



		this.anInt = anInt;
	}






	public static void main(String[] args) {

		OtherClass javaClassMain = new OtherClass();
		javaClassMain.objectMethod();

		Logger.getLogger("1").info("1");
		Logger.getLogger("2").info("2");
	}


	public void objectMethod() {
		System.out.println("=======================================");

		Logger.getLogger("3").info("3");
		Logger.getLogger("4").info("4");
		Logger.getLogger(OtherClass.class).error("error");
	}





}
