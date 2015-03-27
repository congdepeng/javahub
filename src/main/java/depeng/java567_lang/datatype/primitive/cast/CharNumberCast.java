package depeng.java567_lang.datatype.primitive.cast;

/**
 * Created by depeng on 5/3/14.
 */
public class CharNumberCast {
    public static void main(String[] args) {

        char c = 'a';
        int i= c;
        System.out.println(c);//a

        c = '汗';
        i = c;
        System.out.println(c);//汗

        //byte b = c; //ERROR: require byte, found char

        byte b = (byte) c;
        System.out.println(b); // 87

        b = (byte)'a';
        System.out.println(b); //97


        i = 98;
        c = (char) i;
        System.out.println(c); // b








    }


}
