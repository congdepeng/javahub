package depeng.lang.compound.glass;

/**
 * Created by depeng on 6/3/14.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Boy.class);

        Class<Boy> boyClass =Boy.class;
        System.out.println(boyClass.getCanonicalName());


        //boyClass.getFields()

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        Class<int[]> aClass = int[].class;
        System.out.println(aClass);

        Class<Void> voidClass = void.class;
        System.out.println(voidClass);

    }
}
