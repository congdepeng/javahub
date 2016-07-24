package com.depeng.guava;

import org.junit.Test;

public class MapAppTest {
    @Test(expected = UnsupportedOperationException.class)
    public void testName() throws Exception {
        System.out.println("===================================================");
        MapApp mapApp = new MapApp();
        mapApp.immutableMapChange();
        System.out.println("===================================================");
    }
}