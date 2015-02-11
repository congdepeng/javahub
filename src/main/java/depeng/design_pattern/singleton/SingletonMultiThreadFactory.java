package depeng.design_pattern.singleton;


/**
 * 利用double-check lock来保证多线程下的单例，同时改善了第一次初始化后，不需要每次都要synchronized
 */
public class SingletonMultiThreadFactory {

	private static final Object sync = new Object();
	private static Object instance = null;


	public static Object getObject() {
		if (instance == null) {
			synchronized (sync) {
				if (instance == null) {
					instance = new Object();
				}
			}
		}

		return instance;
	}
}
