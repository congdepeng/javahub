package depeng.lang.compound.annotation.define.demo1;

import java.lang.annotation.Annotation;

/**
 * Created by depeng on 11/3/14.
 */
public class EdibleTest {

    @Edible(value = true)
    Item item = new Item();

    public static void main(String[] args) {

        // todo: how to get the real value of item object
        EdibleTest edibleTest = new EdibleTest();
        Class<? extends EdibleTest> aClass = edibleTest.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println(annotations.length);
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            Class<? extends Annotation> aClass1 = annotation.annotationType();
            System.out.println(aClass1);
        }
    }

    public void testGetName() throws Exception {


        EdibleTest edibleTest = new EdibleTest();
        Class<? extends EdibleTest> aClass = edibleTest.getClass();
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            Class<? extends Annotation> aClass1 = annotation.annotationType();
            System.out.println(aClass1);
        }
    }
}
