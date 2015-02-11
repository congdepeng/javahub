package depeng.java7_lang.datatype.primitive;

/**
 * Created by depeng on 9/3/14.
 */
public class PrimitiveDefault {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    boolean bool;

    static byte sb;

    public static void main(String[] args) {
        PrimitiveDefault o = new PrimitiveDefault();
        System.out.println(o.b);
        System.out.println(o.s);
        System.out.println(o.i);
        System.out.println(o.l);
        System.out.println(o.f);
        System.out.println(o.d);
        System.out.println(o.c == '\u0000');
        System.out.println(Character.isDefined(o.c));
        System.out.println(o.bool);

//        0
//        0
//        0
//        0
//        0.0
//        0.0
//        true
//        true
//        false

        System.out.println(sb);
    }

}
