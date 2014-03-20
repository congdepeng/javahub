package depeng.lang.datatype.primitive.array;

import java.util.Arrays;
import java.util.List;

public class ArraysAdd {
    public static void main(String[] args) {
        String[] existing = {"a", "b"};

        List<String> list = Arrays.asList(existing);
        list.add("c");

        for (String s : list) {
            System.out.println(s);
        }


//        Exception in thread "main" java.lang.UnsupportedOperationException
//        at java.util.AbstractList.add(AbstractList.java:148)
//        at java.util.AbstractList.add(AbstractList.java:108)
//        at depeng.lang.datatype.primitive.array.ArraysAdd.main(ArraysAdd.java:11)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:606)
//        at com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)
//
//        Process finished with exit code 1
    }
}
