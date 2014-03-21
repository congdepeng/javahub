package depeng.lang.annotation.annotation_place;

@AnnoAnywhere(value = "class level")
public class Place {

    @AnnoAnywhere(value = "object field")
    private String name;

    @AnnoAnywhere(value = "class static method")
    public static String country = "SG";


    @AnnoAnywhere(value = "constructor")
    public Place(String name) {
        this.name = name;
    }

    @AnnoAnywhere(value = "get name method")
    public String getName() {
        return name;
    }

    @AnnoAnywhere(value = "set name method")
    public void setName(String name) {
        this.name = name;
    }


    @AnnoAnywhere(value = "main method")
    public static void main(String[] args) {
        @AnnoAnywhere(value = "local var")
        int local = 0;
    }
}

