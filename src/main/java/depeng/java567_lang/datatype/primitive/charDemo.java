package depeng.java567_lang.datatype.primitive;

/**
 * Created by depeng on 25/2/14.
 */
public class charDemo {
    public static void main(String[] args) {


        char c0;
//        System.out.println(c0);
        int i=0;

        for (char x = 65535; x < 65536; x++) {
            System.out.println((int)x);

            i++;
            if(i==100)
                break;
        }


    }
}
