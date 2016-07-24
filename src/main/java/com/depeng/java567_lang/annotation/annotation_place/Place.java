package com.depeng.java567_lang.annotation.annotation_place;

@AnnoAnywhere(value = "class level")
public class Place extends FatherOfPlace implements PlaceInterface{

    @Deprecated
    @AnnoAnywhere(value = "object field private String name")
    private String name;

    @Deprecated
    @AnnoAnywhere(value = "object field public String name")
    public String public_name;

    @Deprecated
    @AnnoAnywhere(value = "class static method")
    public static String country = "SG";


    @Deprecated
    @AnnoAnywhere(value = "constructor")
    public Place(String name) {
        this.name = name;
    }

    @AnnoAnywhere(value = "get name method")
    public String getName() {
        return name;
    }

    @AnnoAnywhere(value = "set name method")
    public void setName(@AnnoAnywhere String name) {
        this.name = name;
    }


    @AnnoAnywhere(value = "main method")
    public static void main(@AnnoAnywhere String[] args) {
        @AnnoAnywhere(value = "local var")
        int local = 0;
    }

    @Override
    public int interfaceMethod() {
        return 1110;
    }
}

