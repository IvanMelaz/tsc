package com.lotto.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    @Test
    public void testBigDecimal() {
        double DecimalValue = 3.1432;
        BigDecimal decimal = new BigDecimal(DecimalValue).setScale(2, RoundingMode.DOWN);
        System.out.printf(decimal.toString());
    }

}
