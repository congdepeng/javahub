package com.depeng.exception;

public class App {

    /**
     * 异常在没有抛出前，和普通对象一样
     * 
     * 使用with来构造异常，则堆栈多了一层
     * * * 
     * * *
     * @param args
     */
    public static void main(String[] args) {
        try {
            NewExceptionWithMethod newExceptionWithMethod = new NewExceptionWithMethod();
            //throw newExceptionWithMethod.setName("Set new name");

            throw NewExceptionWithMethod.withName("withName");
            
        } catch (NewExceptionWithMethod e) {
            System.out.println(e.getName());
            e.printStackTrace();
        }
    }
}
