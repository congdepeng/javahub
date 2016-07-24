package com.depeng.guava.case_format;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;

/**
 * 
 * 
 * 
 * * 5种风格， Java主要用后3种 *
 * LOWER_HYPHEN     : lower-camel
 * LOWER_UNDERSCORE : lower_camel
 * LOWER_CAMEL      : lowerCamel
 * UPPER_CAMEL      : LowerCamel
 * UPPER_UNDERSCORE : LOWER_CAMEL
 * 
 * * * * *
 */
public class App {
    public static void main(String[] args) {
        CaseFormat[] values = CaseFormat.values();
        CaseFormat UPPER_UNDERSCORE = CaseFormat.valueOf("UPPER_UNDERSCORE");
        CaseFormat lowerCamel = CaseFormat.LOWER_CAMEL;

        //如果from to 写错了， 就保持原样输出
        Converter<String, String> fromUpperToLowCamel = UPPER_UNDERSCORE.converterTo(lowerCamel);
        String c1 = fromUpperToLowCamel.convert("FROM_---spe-ttToLow");//LOWER_CAMEL知道处理_，但是不知道怎么处理-
        System.out.println(c1);
        String c2 = fromUpperToLowCamel.convert("FROM_GO");
        System.out.println(c2);

        String upper_underscore = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "UPPER_UNDERSCORE");
        System.out.println(upper_underscore);

    }
}
