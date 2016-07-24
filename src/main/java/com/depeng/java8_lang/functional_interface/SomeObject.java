package com.depeng.java8_lang.functional_interface;

/**
 * Created by com.depeng on 23/3/14.
 */
public class SomeObject {
    String name;

    public SomeObject(String name) {
        this.name = name;
    }

    String startsWith(String s) {
        return name+String.valueOf(s.charAt(0));
    }
}
