/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package depeng.java_syntax;

/**
 * 每个子类Extend再构造的时候, 都会构造一个唯一的父类Base的实例, 不会因为extend1回收后影响extend2
 *
 * @author depeng.cdp
 * @version $Id: Extend.java, v 0.1 2015/11/28 depeng.cdp Exp $
 */
public class Extend extends Base {

    public static void main(String[] args) {
        System.out.println("------------------------------");
        Extend extend1 = new Extend();
        System.out.println(extend1);
        System.out.println(extend1.getKey());

        System.out.println("------------------------------");
        Extend extend2 = new Extend();
        System.out.println(extend2);
        System.out.println(extend2.getKey());
    }

    @Override
    public String getKey() {
        return "getKey:" + super.toString();
    }
}
