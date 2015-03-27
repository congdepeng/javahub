package depeng.java567_lang.datatype.primitive.array;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 大多数时候，你将String[]转化成List<String>，是因为String[]是固定大小的，想转换成ArrayList可以动态添加，
 * 但是Arrays.asList(existing)返回的是一个特殊的java.util.Arrays$ArrayList内部类，不支持add方法
 * 
 * 使用Google的Guava库就比较靠谱，返回ArrayList<String>
 * * * 
 * * *
 */
public class ArraysAdd {
    public static void main(String[] args) {
        String[] existing = {"a", "b"};

        List<String> list = Arrays.asList(existing);
        Class<? extends List> aClass = list.getClass();
        System.out.println(aClass);// class java.util.Arrays$ArrayList
        list.add("c");// Exception in thread "main" java.lang.UnsupportedOperationException

        //使用Google的Guava库就比较靠谱，返回ArrayList<String>
        ArrayList<String> strings = Lists.newArrayList(existing);


//        Exception in thread "main" java.java7_lang.UnsupportedOperationException
//        at java.util.AbstractList.add(AbstractList.java:148)
//        at java.util.AbstractList.add(AbstractList.java:108)
//        at depeng.java7_lang.datatype.primitive.array.ArraysAdd.main(ArraysAdd.java:11)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.java7_lang.reflect.Method.invoke(Method.java:606)
//        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)
//
//        Process finished with exit code 1
    }
}
