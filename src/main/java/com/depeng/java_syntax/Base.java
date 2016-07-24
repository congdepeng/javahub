/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package com.depeng.java_syntax;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author com.depeng.cdp
 * @version $Id: Base.java, v 0.1 2015/11/28 com.depeng.cdp Exp $
 */
public abstract class Base {

    private Map map = Maps.newHashMap();

    public Base() {
        System.out.println("Base:         " + super.hashCode() + " hashcode in Base");
        System.out.println("Base:         " + this + " this in Base");
        map.putIfAbsent(getKey(), this);
    }

    public abstract String getKey();

}
