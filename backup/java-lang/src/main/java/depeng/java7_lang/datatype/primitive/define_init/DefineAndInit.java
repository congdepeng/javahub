package depeng.java7_lang.datatype.primitive.define_init;

/**
 * Created by depeng on 4/3/14.
 */
public class DefineAndInit {
    static int var2;

    public static void main(String[] args) {

        int var;
        //System.out.println(var);
        var = 1;
        System.out.println(var);

        System.out.println(var2);

        Wrapper wrapperObject = new Wrapper();
        System.out.println(wrapperObject.var);


        // 256 ASCII时代，如果是英文字面国家够用了
        byte b0 = -128;
        byte b1 = 127;
        System.out.println(--b0);//127
        System.out.println(++b1);//-128

        //万元户 short 65535
        short s0 = -32768;
        short s1 = 32767;
        System.out.println(--s0);//32767
        System.out.println(++s1);//-32768

        //4 bytes,[-2^31, 2^31-1],[-2147483648, 2147483647],[-2G,2G]
        //32位最多寻址空间位4G，4个Billion，40亿而已，也就是IP4的地址数目，不够用了
        int i0 = 0x80000000;//1000,0000 0000,0000 0000,0000 0000,0000
        int i1 = 0x7fffffff;//0111,1111 1111,1111 1111,1111 1111,1111
        System.out.println(--i0);//2147483647
        System.out.println(++i1);//-2147483648

        //8 bytes,[-2^63, 2^63-1]
        //64位，已经超出我能数的清楚的数了
        long l0 = 0x8000000000000000L;
        long l1 = 0x7fffffffffffffffL;
        System.out.println(--l0);//9223372036854775807
        System.out.println(++l1);//-9223372036854775808

        // 65536 和int相同大小，不过都是正数，代表了Unicode时代
        char c0 = Character.MIN_VALUE; //'\u0000';
        char c1 = Character.MAX_VALUE; //'\uFFFF';
        System.out.println(--c0 == 65535);
        System.out.println(++c1 == 0);



        //看不懂

        //Float.MIN_VALUE: the smallest positive nonzero value, 持有正数的最小浮点数
        float f0 = Float.MIN_VALUE;// 0x0.000002P-126f; // 1.4e-45f
        float f1 = Float.MAX_VALUE;// 0x1.fffffeP+127f; // 3.4028235e+38f
        System.out.println(f0 >  0); // true
        System.out.println(f0); // 1.4E-45
        System.out.println(f1); // 3.4028235E38
        System.out.println(--f0); // -1.0 //正浮点最小值无限接近0， -1 就是-1喽
        System.out.println(++f1); // 3.4028235E38 // 最大值是个极限，再加也没用
        System.out.println(++f1 == Float.MAX_VALUE); // true !!!!

        float ff0 = - Float.MIN_VALUE;// - 0x0.000002P-126f; // - 1.4e-45f
        float ff1 = -  Float.MAX_VALUE;// - 0x1.fffffeP+127f; // - 3.4028235e+38f
        System.out.println(ff0); // -1.4E-45
        System.out.println(ff1); // -3.4028235E38



        //看不懂*2
        double d0 = Double.MIN_VALUE;// 0x0.0000000000001P-1022; // 4.9e-324
        double d1 = Double.MAX_VALUE;// 0x1.fffffffffffffP+1023; // 1.7976931348623157e+308
        System.out.println(d0);//4.9E-324
        System.out.println(d1);//1.7976931348623157E308

        double df0 = - Double.MIN_VALUE;// 0x0.0000000000001P-1022; // 4.9e-324
        double df1 = - Double.MAX_VALUE;// 0x1.fffffffffffffP+1023; // 1.7976931348623157e+308
        System.out.println(df0);//-4.9E-324
        System.out.println(df1);//-1.7976931348623157E308

        boolean bool0 = Boolean.FALSE;//false
        boolean bool1 = Boolean.TRUE;//true
        System.out.println(bool0);
        System.out.println(bool1);
        //System.out.println(++bool0);
        //System.out.println(--bool1);






    }

}
