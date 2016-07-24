package com.depeng.jdk_api.system;

import java.util.Properties;

public class SetSystemProperties {


    /**
     *
     * 2个不同的java进程之间的System.getProperties 不会互相影响
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Properties properties = System.getProperties();
        System.out.println(properties.size());
        for (Object o : properties.keySet()) {
            System.out.println(o+" => "+properties.getProperty(o.toString()));
        }

        System.setProperty("ServiceType", "=======================================================================");

         properties = System.getProperties();
        System.out.println(properties.size());
        for (Object o : properties.keySet()) {
            System.out.println(o+" => "+properties.getProperty(o.toString()));
        }


        Thread.sleep(999999999);
    }
}
