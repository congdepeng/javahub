package com.depeng.design_pattern.singleton;


/**
 * 利用类变量来维护一个对象引用，
 *
 *
 * BAD: 多线程下当2个线程差不多同时到达第19行，则同时新建对象
 */

public class Singleton1NotMultiThread {

	private static Singleton1NotMultiThread  instance;

	private Singleton1NotMultiThread() {
	}

	public static Singleton1NotMultiThread getObject(){
		if(instance == null) {
			return new Singleton1NotMultiThread();
		}

		return instance;
	}


}
