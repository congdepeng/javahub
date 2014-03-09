package depeng.lang.compound.glass;

/**
 * Created by depeng on 8/3/14.
 */
public class PassBy {
    public static void main(String[] args) {

        int[] a = {12,1,2};
        int[] b = {12,1,2};

        System.out.println(a);//[I@3a2c4ede
        System.out.println(b);//[I@32edeea8
        System.out.println(a == b);//false

        pass(a, b);

        String s = null;
        Object i = null;
        System.out.println(s == i ); //true

    }


    private static void pass(Object o1, Object o2){
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o1 == o2);

//        [I@3ff23f8b
//        [I@4a248a0a
//        false
    }

}
