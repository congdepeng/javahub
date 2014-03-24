package depeng.java8_lang.functional_interface.scope;

/**
 * Created by depeng on 23/3/14.
 */
public class LambdaScope {
    static int outer_static= 100;
    int outer_obj = 1;

//    void testScopesBefore() {
//        Converter<Integer, String> stringIntegerConverter1 = (from) -> {
//            return String.valueOf(outer_static + from);
//        };
//
//        String convert = stringIntegerConverter1.convert(1);
//        System.out.println(convert);
//    }
//
//    void testScopes() {
//        Converter<Integer, String> stringIntegerConverter1 = (from) -> {
//            outer_static = 999;
//            return String.valueOf(outer_static + from);
//        };
//
//        String convert = stringIntegerConverter1.convert(1);
//        System.out.println(convert);
//    }
//
//    void testObjFieldBefore() {
//        Converter<Integer, String> stringIntegerConverter1 = (from) -> {
//            return String.valueOf(outer_obj + from);
//        };
//
//        String convert = stringIntegerConverter1.convert(1);
//        System.out.println(convert);
//    }
//
//    void testObjField() {
//        outer_obj = 999;
//        Converter<Integer, String> stringIntegerConverter1 = (from) -> {
//            return String.valueOf(outer_obj + from);
//        };
//
//        String convert = stringIntegerConverter1.convert(1);
//        System.out.println(convert);
//    }
//
//    public static void main(String[] args) {
//        LambdaScope lambdaScope = new LambdaScope();
//        lambdaScope.testScopesBefore();
//        lambdaScope.testScopes();
//        lambdaScope.testScopesBefore();
//
//        lambdaScope.testObjFieldBefore();
//        lambdaScope.testObjField();
//        lambdaScope.testObjFieldBefore();
//    }
}
