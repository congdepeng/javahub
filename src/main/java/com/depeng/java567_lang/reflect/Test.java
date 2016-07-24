package com.depeng.java567_lang.reflect;


import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception {

        Field field1 = Thread.class.getDeclaredField("threadLocals");
        field1.setAccessible(true);
        Object o1 = field1.get(Thread.currentThread());
        Field field2 = o1.getClass().getDeclaredField("table");
        field2.setAccessible(true);
        Object[] o2 = (Object[]) field2.get(o1);
        for (Object temp : o2) {
            if (temp != null) {
                Field field3 = temp.getClass().getDeclaredField("value");
                field3.setAccessible(true);
                Object o3 = field3.get(temp);
                System.out.println(o3);
            }
        }
    }

}
