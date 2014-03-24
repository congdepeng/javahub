package depeng.java7_lang.datatype.compound;

import java.lang.reflect.Field;

public class GetClassDeclaredFields {
    public static void main(String[] args) {
        Field[] fields = DefaultValue.class.getDeclaredFields();
        System.out.println(fields.length);     //gives no of fields
        for (Field field : fields)
        {
            System.out.println(field.getName());   //gives the names of the fields
        }
    }
}
