package depeng.lang.datatype.compound.annotation.define.demo1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by depeng on 11/3/14.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Edible {
    boolean value() default false;
}
