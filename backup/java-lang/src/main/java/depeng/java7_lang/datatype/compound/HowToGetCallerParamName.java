package depeng.java7_lang.datatype.compound;


public class HowToGetCallerParamName {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String paramName = "a string";
        method(paramName);
    }

    public static void method(String a) throws NoSuchFieldException, IllegalAccessException {

        // How can I get the caller parameter name ?
        // in this example, I need to get a String "paramName" which is the actually parameter name of the variable

//        String actuallyParamName = getActuallyParameterName();
//        System.out.println(actuallyParamName); // print "paramName"
        System.out.println(a);
//        Thread.currentThread().getContextClassLoader()


    }



}
