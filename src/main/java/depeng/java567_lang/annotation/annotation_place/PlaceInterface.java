package depeng.java567_lang.annotation.annotation_place;

/**
 * Created by depeng on 22/3/14.
 */
@Deprecated
@AnnoAnywhere
@SuppressWarnings(value = "PlaceInterface")//source only
public interface PlaceInterface {

    @SuppressWarnings(value = "di")  @Deprecated int def_int=0;
    @SuppressWarnings(value = "pi")  @Deprecated public int public_int=0;


    @SuppressWarnings(value = "interfaceMethod") @Deprecated  public int interfaceMethod();

}
