package depeng.java7_lang.datatype.compound.annotation.define.unfinishedDemo;

import depeng.java7_lang.datatype.compound.annotation.define.demo1.Item;

import java.lang.annotation.*;

/**
 * Created by depeng on 12/3/14.
 */


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,
        ElementType.CONSTRUCTOR,ElementType.ANNOTATION_TYPE,
        ElementType.PACKAGE,ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@Inherited
public @interface Unfinished {

    // 可以在注解里面定义枚举类型
    public enum Priority { LOW, MEDIUM, HIGH }
    // 也可以定义int
    public int a = 1;
    public Object object = new Object();
    public static Item item = new Item();


    String value() default ""+ a ;
    String[] changedBy() default "";
    String[] lastChangedBy() default "";
    Priority priority() default Priority.MEDIUM;
    String createdBy() default "James Gosling";
    String lastChanged() default "2011-07-08";

    // 如下返回类型是无效的
    //Item testItem();
    //Object testObject();
}
