package com.depeng.java8_lang.functional_interface;

/**
 * Created by com.depeng on 23/3/14.
 */
//@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);

}
