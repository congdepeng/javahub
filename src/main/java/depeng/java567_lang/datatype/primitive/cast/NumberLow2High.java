package depeng.java567_lang.datatype.primitive.cast;

/**
 * Created by depeng on 4/3/14.
 */
public class NumberLow2High {
    public static void main(String[] args) {

        //number from low to high
        byte b = 127;
        short s = b;
        int i = s;
        long l = i;
        System.out.println(b+s+i+l);

        float f = i;
        System.out.println(f); // 1.0
        double d = f;
        System.out.println(d); // 1.0




    }
}
