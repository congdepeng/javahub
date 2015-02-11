package depeng.depeng.java7_lang.annotation.annotation_place;

/**
 * Created by depeng on 22/3/14.
 */
@Deprecated
public class FatherOfPlace {
    @Deprecated private String private_fname;
    @Deprecated public String public_fname;


    @Deprecated  private String private_method() {
        return private_fname;
    }

    @Deprecated  public String public_method() {
        return private_fname;
    }

    @Deprecated private static String private_static_method() {
        return "private_static_method";
    }

    @Deprecated public static String public_static_method() {
        return "public_static_method";
    }

    @Deprecated public String getPrivate_fname() {
        return private_fname;
    }

    @Deprecated public void setPrivate_fname(String private_fname) {
        this.private_fname = private_fname;
    }

    @Deprecated public String getPublic_fname() {
        return public_fname;
    }

    @Deprecated public void setPublic_fname(String public_fname) {
        this.public_fname = public_fname;
    }
}
