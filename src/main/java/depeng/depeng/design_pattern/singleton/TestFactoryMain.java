package depeng.depeng.design_pattern.singleton;

/**
 * Created by depeng on 12/11/13.
 */
public class TestFactoryMain implements Runnable{


	public static void main(String[] args) {

		Thread thread1 = new Thread(new TestFactoryMain());
		Thread thread2 = new Thread(new TestFactoryMain());
		Thread thread3 = new Thread(new TestFactoryMain());

		thread1.run();
		thread2.run();
		thread3.run();

	}


	@Override
	public void run() {
		Object object = SingletonMultiThreadFactory.getObject();
		System.out.println(object.toString());
	}
}
