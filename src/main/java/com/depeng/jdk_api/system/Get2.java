package com.depeng.jdk_api.system;

import java.util.Properties;

public class Get2 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties.size());
        for (Object o : properties.keySet()) {
            System.out.println(o+" => "+properties.getProperty(o.toString()));
        }

        System.setProperty("ServiceType", "##############################################################");

        properties = System.getProperties();
        System.out.println(properties.size());
        for (Object o : properties.keySet()) {
            System.out.println(o+" => "+properties.getProperty(o.toString()));
        }
    }
}
