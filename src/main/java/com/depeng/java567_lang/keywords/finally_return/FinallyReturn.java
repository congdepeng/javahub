package com.depeng.java567_lang.keywords.finally_return;

public class FinallyReturn {

    public static void main(String[] args) {
        FinallyReturn finallyReturn = new FinallyReturn();
        System.out.println(finallyReturn.method1());
        System.out.println(finallyReturn.method3());
    }


    /**
     * 尽管return 1优先执行了，但是finally最后肯定执行，所以结果是return 2；
     *
     * @return
     */
    public int method1() {
        try {
            System.out.println("try");
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
//        return 3;
    }


    /**
     * return 3 是在finally执行后才执行的，如果return 2;就无法往下跑到return 3;
     *
     * @return
     */
    public int method3() {
        try {
            System.out.println("method3 try");
        } finally {
            System.out.println("method3 finally");
            //return 2;
        }
        System.out.println("print before return 3");
        return 3;
    }

}
