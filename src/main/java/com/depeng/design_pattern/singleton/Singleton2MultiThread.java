package com.depeng.design_pattern.singleton;


/**
 * 利用类变量来维护一个对象引用，使用synchronized关键字来保证方法级的锁
 *
 * BAD: 当类初始化一次以后，之后的调用效率低下，因为这个时候锁是没有必要的了
 */

public class Singleton2MultiThread {

	private static Singleton2MultiThread instance;

	private Singleton2MultiThread() {
	}

	public static synchronized Singleton2MultiThread getObject(){
		if(instance == null) {
			return new Singleton2MultiThread();
		}

		return instance;
	}


}
