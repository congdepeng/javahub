package depeng.lang.annotation.wiki_demo;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

/**
 * Created by depeng on 21/3/14.
 */
public class GetAnnotation {
    public static void main(String[] args) {
        Class<SetCustomAnnotation> glass = SetCustomAnnotation.class;


//        /**
//         *  ??????????????     JDK 8 only
//         */
//        AnnotatedType[] annotatedInterfaces = glass.getAnnotatedInterfaces();
//        for (AnnotatedType annotatedInterface : annotatedInterfaces) {
//            System.out.println(annotatedInterface);
//        }
//
//
//
//        /**
//         *  ??????????????  JDK 8 only
//         */
//
//        AnnotatedType annotatedSuperclass = glass.getAnnotatedSuperclass();
//        System.out.println(annotatedSuperclass);

//
//        /** JDK 8 only
//         *
//         * 为了支持@Repeatable
//         */
//        TypeHeader[] annotationsByType = glass.getAnnotationsByType(TypeHeader.class);
//        for (TypeHeader header : annotationsByType) {
//            System.out.println(header);
//        }


        /**
         * 得到类的注解，获取在代码中注解到该类的注解的具体的值
         */
        Annotation[] annotations = glass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            TypeHeader typeHeader = (TypeHeader) annotation;
            String developer = typeHeader.developer();
            System.out.println(developer);

        }


        /**
         *
         * 这个方法是上一个方法的快捷方式，如果TypeHeader没有注解到glass，返回null
         */
        TypeHeader typeHeader = glass.getAnnotation(TypeHeader.class);
        String developer = typeHeader.developer();
        System.out.println(developer);


        /**
         * return null
         *
         */
        Retention retention = glass.getAnnotation(Retention.class);
        assert retention == null;


        /**
         * 该方法返回直接标注在此类上的注解，忽略继承的注解
         */
        Annotation[] declaredAnnotations = glass.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }


    }
}
