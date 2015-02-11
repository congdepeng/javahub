package depeng.depeng.design_pattern.singleton;



/**
 * Created by depeng on 12/11/13.
 */
public class SingletonMultiThreadFactory {



	private static Object sync = new Object();

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
