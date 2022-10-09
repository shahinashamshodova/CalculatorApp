package com.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CalculateTest {
    @Test
    public void checkCalculate()
    {
        Calculate test_obj = new Calculate("2 + 3 + 5 * 6");
        assertEquals(35, test_obj.evaluate());

        test_obj = new Calculate("2 / 2");
        assertEquals(1, test_obj.evaluate());

        test_obj = new Calculate("50 * 10");
        assertEquals(500, test_obj.evaluate());

        test_obj = new Calculate("50 - 10");
        assertEquals(40, test_obj.evaluate());
    }
}
