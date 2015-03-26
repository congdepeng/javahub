package depeng.reflection;

public class CommonVo {

    private String comPrivate;
    protected String comProtected;
    String comDefault;
    public String comPublic;


    public String getComDefault() {
        return comDefault;
    }

    public void setComDefault(String comDefault) {
        this.comDefault = comDefault;
    }

    public String getComPrivate() {
        return comPrivate;
    }

    public void setComPrivate(String comPrivate) {
        this.comPrivate = comPrivate;
    }

    public String getComProtected() {
        return comProtected;
    }

    public void setComProtected(String comProtected) {
        this.comProtected = comProtected;
    }

    public String getComPublic() {
        return comPublic;
    }

    public void setComPublic(String comPublic) {
        this.comPublic = comPublic;
    }
}
