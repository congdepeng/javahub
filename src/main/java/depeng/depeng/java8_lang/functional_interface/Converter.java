package depeng.depeng.java8_lang.functional_interface;

/**
 * Created by depeng on 23/3/14.
 */
//@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);

}
