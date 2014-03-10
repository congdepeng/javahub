package depeng.lang.compound.annotation;

import java.util.ArrayList;

/**
 * Created by depeng on 11/3/14.
 */
public class SuppressWarningsShowcase {

    @SuppressWarnings("unchecked")
    public static void warning() {
        ArrayList objects = new ArrayList();
        objects.add("ss");
        objects.add(11);
    }

    public static void main(String[] args) {
        warning();
    }
}
