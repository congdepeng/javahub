package com.depeng.jdk_api.thread;
public class LineNo {
    public static int getLineNumber() {
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static String getFileName() {
        return Thread.currentThread().getStackTrace()[2].getFileName();
    }
    public static void main(String args[]) {
        System.out.println("["+getFileName()+"："+ getLineNumber()+"]"+"Hello World!");
        System.out.println("["+getFileName()+"："+ getLineNumber()+"]"+"Hello World!");
        System.out.println("["+getFileName()+"："+ getLineNumber()+"]"+"Hello World!");

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stackTraceElement.getMethodName();
        }
    }

// About Magic No. == 2
//    0 是thread.getCurrentThread()
//    1 是getLineNumber()
//    2 才是调用getLineNumber的类
}
