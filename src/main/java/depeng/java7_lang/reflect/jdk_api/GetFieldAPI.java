package depeng.java7_lang.reflect.jdk_api;

import depeng.java7_lang.annotation.annotation_place.Place;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by depeng on 22/3/14.
 */
public class GetFieldAPI {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<Place> glass = Place.class;

        /**
         * fields: 4 methods，group by in 2 groups
         * 该方法从一个黑盒的角度去调用这个类，得到所有非private的属性，包括父类和实现的接口的属性
         *
         * !!!!!! NOT include private fields  !!!!!!
         */

        Field[] fields = glass.getFields();//只得到类静态field，为什么？因为只取public的属性，跟是否static无关
//        for (Field field : fields) {
//            System.out.println();
//            System.out.println(field);
//            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
//            for (Annotation declaredAnnotation : declaredAnnotations) {
//                System.out.println(declaredAnnotation);
//            }
//        }

        /**
         * 该方法是上一个方法的特例
         *
         */

        //Field name = glass.getField("name");//Exception in thread "main" java.java7_lang.NoSuchFieldException: name
        Field public_name = glass.getField("public_int");// can get public
//        System.out.println(public_name);//yes,get


        /**
         * 此方法从白盒的角度去获得该类本身定义的属性，属于SOURCE级别的审查
         *
         * self fields only, include private methods
         *
         */

        Field[] declaredFields = glass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println();
            System.out.println(declaredField);
            Annotation[] declaredAnnotations = declaredField.getDeclaredAnnotations();
            for (Annotation declaredAnnotation : declaredAnnotations) {
                System.out.println(declaredAnnotation);
            }
        }
        /**
         * refer to previous method
         *
         */

        Field name = glass.getDeclaredField("name");


    }
}
