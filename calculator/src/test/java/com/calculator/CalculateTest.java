package com.calculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class CalculateTest {
    @Test
    public void checkEmptyExpression()
    {
        Calculate test_obj = new Calculate("2 + 3 + 5 * 6");
        assertEquals(35, test_obj.evaluate());
    }
}
