package depeng.lang.primitive;

/**
 * Created by depeng on 25/2/14.
 */
public class byteDemo {

    public static void main(String[] args) {

        byte b0;
        //System.out.println(b0); // Compile error: must init

//        byte b1 = 0;
//        System.out.println(b1);

//        b1 = -128;
        //b1 = -129; //Compile error: exceed range(-128, 127)

//        b1=127;
        //b1=128; //Compile error: exceed range(-128, 127)


        int i =0;
        for (byte b = 127; b < 128; b++) {
            System.out.println(b);

            i++;
            if(i==20)
                break;
        }

    }

}
