package com.depeng.reflection;

public class SearchVo extends CommonVo {


    private String sPrivate;
    protected String sProtected;
    String sDefault;
    public String sPublic;

    public String getsDefault() {
        return sDefault;
    }

    public void setsDefault(String sDefault) {
        this.sDefault = sDefault;
    }

    public String getsPrivate() {
        return sPrivate;
    }

    public void setsPrivate(String sPrivate) {
        this.sPrivate = sPrivate;
    }

    public String getsProtected() {
        return sProtected;
    }

    public void setsProtected(String sProtected) {
        this.sProtected = sProtected;
    }

    public String getsPublic() {
        return sPublic;
    }

    public void setsPublic(String sPublic) {
        this.sPublic = sPublic;
    }
}
