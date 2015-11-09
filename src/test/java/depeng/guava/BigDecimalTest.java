/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package depeng.guava;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * @author depeng.cdp
 * @version $Id: BigDecimalTest.java, v 0.1 2015/10/24 depeng.cdp Exp $
 */
public class BigDecimalTest {

    @Test
    public void testName() throws Exception {

        //0.3333
        assertEquals(new BigDecimal("0.4"),
            new BigDecimal("1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_UP));
        assertEquals(new BigDecimal("0.3"),
            new BigDecimal("1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_DOWN));

        assertEquals(new BigDecimal("0.4"),
            new BigDecimal("1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_CEILING));
        //-0.33333
        assertEquals(new BigDecimal("-0.3"),
            new BigDecimal("-1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_CEILING));

        assertEquals(new BigDecimal("0.3"),
            new BigDecimal("1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_FLOOR));
        assertEquals(new BigDecimal("-0.4"),
            new BigDecimal("-1").divide(new BigDecimal("3"), 1, BigDecimal.ROUND_FLOOR));

        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.1").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.11").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.12").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.13").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.14").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.1499999").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.2"),
            new BigDecimal("1.15").setScale(1, BigDecimal.ROUND_HALF_UP));
        assertEquals(new BigDecimal("1.2"),
            new BigDecimal("1.16").setScale(1, BigDecimal.ROUND_HALF_UP));

        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.14").setScale(1, BigDecimal.ROUND_HALF_DOWN));
        assertEquals(new BigDecimal("1.1"),
            new BigDecimal("1.15").setScale(1, BigDecimal.ROUND_HALF_DOWN));

        assertEquals(new BigDecimal("1.2"),
            new BigDecimal("1.16").setScale(1, BigDecimal.ROUND_HALF_DOWN));
        assertEquals(new BigDecimal("1.2"),
            new BigDecimal("1.17").setScale(1, BigDecimal.ROUND_HALF_DOWN));

        assertEquals(new BigDecimal("0"),
            new BigDecimal("0.17").setScale(0, BigDecimal.ROUND_HALF_DOWN));
        assertEquals(new BigDecimal("0"),
            new BigDecimal("0.500000").setScale(0, BigDecimal.ROUND_HALF_DOWN));
        assertEquals(new BigDecimal("1"),
            new BigDecimal("0.5000001").setScale(0, BigDecimal.ROUND_HALF_DOWN));
        assertEquals(new BigDecimal("1"),
            new BigDecimal("0.50900001").setScale(0, BigDecimal.ROUND_HALF_DOWN));

    }
}
