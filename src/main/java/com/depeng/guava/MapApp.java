package com.depeng.guava;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class MapApp {
    public void immutableMapChange() {
        Map<String, String> of = ImmutableMap.of("key", "value");
        String newKey = of.put("newKey", "");
        System.out.println(newKey);
    }
}
