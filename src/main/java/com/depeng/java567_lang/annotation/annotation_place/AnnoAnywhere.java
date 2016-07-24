package com.depeng.java567_lang.annotation.annotation_place;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoAnywhere {
    String value() default "default value";
}
