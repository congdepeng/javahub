package depeng.java8.functional_interface;

/**
 * Created by depeng on 23/3/14.
 */
public class SomeObject {
    String name;

    public SomeObject(String name) {
        this.name = name;
    }

    String startsWith(String s) {
        return name+String.valueOf(s.charAt(0));
    }
}
