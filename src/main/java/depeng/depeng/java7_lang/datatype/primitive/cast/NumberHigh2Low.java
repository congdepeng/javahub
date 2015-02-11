package depeng.depeng.java7_lang.datatype.primitive.cast;

/**
 * Created by depeng on 4/3/14.
 */
public class NumberHigh2Low {
    public static void main(String[] args) {


        // double 的往下转换，不超过小值的取值范围行为正常，超过了你最好不要这样做，行为异常

        double d = Double.MAX_VALUE;

        //float f = d; // error: incompatible type
        float f = (float) d;
        System.out.println(f == Double.POSITIVE_INFINITY);

        d = - Double.MIN_VALUE;
        f = (float) d;
        System.out.println(f);

        d = 100.0;
        f = (float) d;
        System.out.println(f);


        // int 之间的转换
        long l = Long.MAX_VALUE;
        int i = (int) l;
        System.out.println(i); // -1

        l = Long.MIN_VALUE;
        i = (int) l;
        System.out.println(i); // 0

        l = 999999999999999999l; // 注意！！！后面加了一个l，
        i = (int) l;
        System.out.println(l); // 999999999999999999l
        System.out.println(i); // -1486618625 溢出了

        i = 1000000000;
        short s = (short) i;
        System.out.println(s); //-13824  溢出

        // 所以进过精心构造的溢出能得到很多好玩的数值

        s = 128;
        byte b = (byte) s;
        System.out.println(b); // -128 溢出到byte的最小值









    }
}
