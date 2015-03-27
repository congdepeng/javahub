package depeng.java567_lang.datatype.compound.array;

/**
 * Created by depeng on 8/3/14.
 */
public class ArrayDemo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

//        //1.1 define a array which length is 10
//        int[] intArray = new int[10];
//        for (int i : intArray) {
//            System.out.println(i==0);//always true
//        }
//
//        //1.2 define a array by literal
//        int[] intLiteral = {1,2,3,4};
//
//        //1.3 define a array by Class
//        // java.java7_lang.InstantiationException: [I
//        Class<int[]> aClass1 = int[].class;
//        int[] ints = aClass1.newInstance();
//        int length1 = ints.length;
//        System.out.println(length1);
//
//
//        //properties
//        int length = intArray.length;
//        System.out.println(length);//10
//
//        //method
//        int[] clone = intArray.clone();
//        System.out.println(clone); //[I@6a3449a8
//        System.out.println(intArray); //[I@ecfeb11
//        //?这个clone是shallow clone还是deep clone？
//
//
//
//        // get
//        int i = intArray[0];
//        int ie = intArray[intArray.length];
//
//        //set
//        intArray[0] = 100;
//        // out of range
//        //intArray[11] = 100;//java.java7_lang.ArrayIndexOutOfBoundsException: 10



        Class<int[]> aClass = int[].class;
        System.out.println(aClass.getCanonicalName());//int[]
        System.out.println(aClass.getName());//[i
        System.out.println(aClass.getSimpleName());//int[]


        String[] strings = new String[10];
        Class<? extends String[]> stringClass = strings.getClass();
        System.out.println(stringClass.getCanonicalName());//java.java7_lang.String[]
        System.out.println(stringClass.getName());//[Ljava.java7_lang.String;
        System.out.println(stringClass.getSimpleName());//String[]
    }
}
