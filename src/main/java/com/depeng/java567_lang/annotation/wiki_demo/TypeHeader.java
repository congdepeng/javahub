package com.depeng.java567_lang.annotation.wiki_demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// This is the annotation to be processed
// Default for Target is all Java Elements
// Change retention policy to RUNTIME (default is CLASS)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeHeader {
    // Default value specified for developer attribute
    String developer() default "Unknown";
    String lastModified();
    String [] teamMembers();
    int meaningOfLife();
}

/**
 *
 * - 注解实现为一个接口，同时实现了java/java7_lang/annotation/Annotation接口
 * - 记录下了RetentionPolicy
 * - 定义了对应的抽象方法，同时可以记录下默认值。
 *
 *
 */


/**
 *
 * 下面是IDEA的View > Byte Code
 */
//// class version 52.0 (52)
//// access flags 0x2601
//public abstract @interface com.depeng/java7_lang/annotation/wiki_demo/TypeHeader implements java/java7_lang/annotation/Annotation  {
//
//// compiled from: TypeHeader.java
//
//@Ljava/java7_lang/annotation/Retention;(value=Ljava/java7_lang/annotation/RetentionPolicy;.RUNTIME)
//
//// access flags 0x401
//public abstract developer()Ljava/java7_lang/String;
//default="Unknown"
//
//// access flags 0x401
//public abstract lastModified()Ljava/java7_lang/String;
//
//// access flags 0x401
//public abstract teamMembers()[Ljava/java7_lang/String;
//
//// access flags 0x401
//public abstract meaningOfLife()I
//        }




/**
 *
 * 下面是javap
 */
//
//Classfile /Users/com.depeng/github/javahub/java7_lang/target/classes/com.depeng/java7_lang/annotation/wiki_demo/TypeHeader.class
//        Last modified Mar 20, 2014; size 495 bytes
//        MD5 checksum 3cd2926c4d4a286554e74899d6bd6758
//        Compiled from "TypeHeader.java"
//public interface com.depeng.java7_lang.annotation.wiki_demo.TypeHeader extends java.java7_lang.annotation.Annotation
//        SourceFile: "TypeHeader.java"
//        RuntimeVisibleAnnotations:
//        0: #16(#17=e#18.#19)
//        minor version: 0
//        major version: 52
//        flags: ACC_PUBLIC, ACC_INTERFACE, ACC_ABSTRACT, ACC_ANNOTATION
//        Constant pool:
//        #1 = Class              #20            // com.depeng/java7_lang/annotation/wiki_demo/TypeHeader
//        #2 = Class              #21            // java/java7_lang/Object
//        #3 = Class              #22            // java/java7_lang/annotation/Annotation
//        #4 = Utf8               developer
//        #5 = Utf8               ()Ljava/java7_lang/String;
//        #6 = Utf8               AnnotationDefault
//        #7 = Utf8               Unknown
//        #8 = Utf8               lastModified
//        #9 = Utf8               teamMembers
//        #10 = Utf8               ()[Ljava/java7_lang/String;
//        #11 = Utf8               meaningOfLife
//        #12 = Utf8               ()I
//        #13 = Utf8               SourceFile
//        #14 = Utf8               TypeHeader.java
//        #15 = Utf8               RuntimeVisibleAnnotations
//        #16 = Utf8               Ljava/java7_lang/annotation/Retention;
//        #17 = Utf8               value
//        #18 = Utf8               Ljava/java7_lang/annotation/RetentionPolicy;
//        #19 = Utf8               RUNTIME
//        #20 = Utf8               com.depeng/java7_lang/annotation/wiki_demo/TypeHeader
//        #21 = Utf8               java/java7_lang/Object
//        #22 = Utf8               java/java7_lang/annotation/Annotation
//        {
//public abstract java.java7_lang.String developer();
//        descriptor: ()Ljava/java7_lang/String;
//        flags: ACC_PUBLIC, ACC_ABSTRACT
//        AnnotationDefault:
//        default_value: s#7
//public abstract java.java7_lang.String lastModified();
//        descriptor: ()Ljava/java7_lang/String;
//        flags: ACC_PUBLIC, ACC_ABSTRACT
//
//public abstract java.java7_lang.String[] teamMembers();
//        descriptor: ()[Ljava/java7_lang/String;
//        flags: ACC_PUBLIC, ACC_ABSTRACT
//
//public abstract int meaningOfLife();
//        descriptor: ()I
//        flags: ACC_PUBLIC, ACC_ABSTRACT
//        }