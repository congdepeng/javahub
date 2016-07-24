package com.depeng.java567_lang.datatype.compound.glass;

/**
 * Created by com.depeng on 8/3/14.
 */
public class NewObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Boy boy = new Boy();
        System.out.println(boy);

        Class<?> aClass = Class.forName("com.depeng.java7_lang.datatype.compound.glass.Boy");

        Object o = aClass.newInstance();

        System.out.println(boy == o);
        System.out.println(boy.equals(o)); // you can rewrite this equals method


    }

}
