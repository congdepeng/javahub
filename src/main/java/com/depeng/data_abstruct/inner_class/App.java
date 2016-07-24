package com.depeng.data_abstruct.inner_class;

public class App {

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        
        //下面一行报错，因为PublicInnerClass不是静态的，和引用一个非静态属性一样，无法访问
        //OutClass.PublicInnerClass publicInnerClass = new OutClass.PublicInnerClass();

        
        
        
        //可以创建一个内部静态类, 静态内部类又叫“嵌套内部类”
            // -（优点）  它的创建是不需要依赖于外围类的
            // -（缺点）  它不能使用任何外围类的非static成员变量和方法
        OutClass.FinalStaticInnerClass finalStaticInnerClass = new OutClass.FinalStaticInnerClass("嵌套内部类");
        String say = finalStaticInnerClass.say();
        System.out.println(say);
    }
}
