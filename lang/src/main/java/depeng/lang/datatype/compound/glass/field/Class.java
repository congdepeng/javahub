package depeng.lang.datatype.compound.glass.field;


/**
 * Created by depeng on 12/11/13.
 */
public class Class {
	public static final MathematicTeacher mt = new MathematicTeacher(100,"Jack");


    /**
     * Created by depeng on 12/11/13.
     */
    public static class Main {
        public static void main(String[] args) {
            java.lang.Class classClass = Object.class;
            Object o = new Object();
            java.lang.Class objectClass = o.getClass();

            System.out.println(classClass);
            System.out.println(objectClass);

            System.out.println(classClass.hashCode());
            System.out.println(objectClass.hashCode());

            assert classClass == objectClass;
        }

    }
}
