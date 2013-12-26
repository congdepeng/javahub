package depeng.lang.glass;

/**
 * Created by depeng on 12/11/13.
 */
public class Main {
	public static void main(String[] args) {
		Class classClass = Object.class;
		Object o = new Object();
		Class objectClass = o.getClass();

		System.out.println(classClass);
		System.out.println(objectClass);

		System.out.println(classClass.hashCode());
		System.out.println(objectClass.hashCode());

		assert classClass == objectClass;
	}

}
