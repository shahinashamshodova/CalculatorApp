package com.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue("String '127435+34569-12345*10+50' should be valid", App.errorChecking("127435+34569-12345*10+50"));
        assertTrue("String '-127435+34569-12345*10+50' should be valid", App.errorChecking("-127435+34569-12345*10+50"));
        assertTrue("String '-127435+-34569-12345*10+50' should be valid", App.errorChecking("-127435+-34569-12345*10+50"));
        assertTrue("String '-127435+-34569--12345*10+50' should be valid", App.errorChecking("-127435+-34569--12345*10+50"));
        assertTrue("String '-127435+-34569--12345*-10+50' should be valid", App.errorChecking("-127435+-34569--12345*-10+50"));
        assertTrue("String '-127435+-34569--12345*-10+-50' should be valid", App.errorChecking("-127435+-34569--12345*-10+-50"));

        assertTrue("String '10/2' should be valid", App.errorChecking("10/2"));
        assertTrue("String '10/-2' should be valid", App.errorChecking("10/-2"));
        assertTrue("String '-10/-2' should be valid", App.errorChecking("-10/-2"));

        assertTrue("String '0' should be valid", App.errorChecking("0"));
        assertTrue("String '1' should be valid", App.errorChecking("1"));
        assertTrue("String '2' should be valid", App.errorChecking("2"));
        assertTrue("String '3' should be valid", App.errorChecking("3"));
        assertTrue("String '4' should be valid", App.errorChecking("4"));
        assertTrue("String '5' should be valid", App.errorChecking("5"));
        assertTrue("String '6' should be valid", App.errorChecking("6"));
        assertTrue("String '7' should be valid", App.errorChecking("7"));
        assertTrue("String '8' should be valid", App.errorChecking("8"));
        assertTrue("String '9' should be valid", App.errorChecking("9"));

        assertTrue("String '84746' should be valid", App.errorChecking("84746"));
        assertTrue("String '945786893476' should be valid", App.errorChecking("945786893476"));
        assertTrue("String '32987368945' should be valid", App.errorChecking("32987368945"));

        assertTrue("String '-0' should be valid", App.errorChecking("-0"));
        assertTrue("String '-1' should be valid", App.errorChecking("-1"));
        assertTrue("String '-2' should be valid", App.errorChecking("-2"));
        assertTrue("String '-3' should be valid", App.errorChecking("-3"));
        assertTrue("String '-4' should be valid", App.errorChecking("-4"));
        assertTrue("String '-5' should be valid", App.errorChecking("-5"));
        assertTrue("String '-6' should be valid", App.errorChecking("-6"));
        assertTrue("String '-7' should be valid", App.errorChecking("-7"));
        assertTrue("String '-8' should be valid", App.errorChecking("-8"));
        assertTrue("String '-9' should be valid", App.errorChecking("-9"));

        assertTrue("String '-7980457689345' should be valid", App.errorChecking("-7980457689345"));
        assertTrue("String '-89345769' should be valid", App.errorChecking("-89345769"));
        assertTrue("String '-2524656568678789' should be valid", App.errorChecking("-2524656568678789"));

    }

    @Test
    public void shouldAnswerWithFalse()
    {
        //Checking for operators at start, double operators and operators at end
        assertFalse("String '+12435+34569-12345*10+50' should not be valid", App.errorChecking("+12435+34569-12345*10+50"));
        assertFalse("String '++12435+34569-12345*10+50' should not be valid", App.errorChecking("++12435+34569-12345*10+50"));
        assertFalse("String '+++12435+34569-12345*10+50' should not be valid", App.errorChecking("+++12435+34569-12345*10+50"));
        assertFalse("String '12435+34569++12345+10+50' should not be valid", App.errorChecking("12435++34569++12345+10+50"));
        assertFalse("String '12435+34569-12345*10+50+' should not be valid", App.errorChecking("12435+34569-12345*10+50+"));
        assertFalse("String '12435+34569-12345*10+50++' should not be valid", App.errorChecking("12435+34569-12345*10+50++"));

        assertFalse("String '--12435+34569-12345*10+50' should not be valid", App.errorChecking("--12435+34569-12345*10+50"));
        assertFalse("String '---12435+34569-12345*10+50' should not be valid", App.errorChecking("---12435+34569-12345*10+50"));
        assertFalse("String '12435+34569-12345*10+50-' should not be valid", App.errorChecking("12435+34569-12345*10+50-"));
        assertFalse("String '12435+34569-12345*10+50--' should not be valid", App.errorChecking("12435+34569-12345*10+50--"));

        assertFalse("String '/12435+34569-12345*10+50' should not be valid", App.errorChecking("/12435+34569-12345*10+50"));
        assertFalse("String '//12435+34569-12345*10+50' should not be valid", App.errorChecking("//12435+34569-12345*10+50"));
        assertFalse("String '///12435+34569-12345*10+50' should not be valid", App.errorChecking("///12435+34569-12345*10+50"));
        assertFalse("String '10//2' should not be valid", App.errorChecking("10//2"));
        assertFalse("String '12435+34569-12345*10+50/' should not be valid", App.errorChecking("12435+34569-12345*10+50/"));
        assertFalse("String '12435+34569-12345*10+50//' should not be valid", App.errorChecking("12435+34569-12345*10+50//"));

        assertFalse("String '*12435+34569-12345*10+50' should not be valid", App.errorChecking("*12435+34569-12345*10+50"));
        assertFalse("String '**12435+34569-12345*10+50' should not be valid", App.errorChecking("**12435+34569-12345*10+50"));
        assertFalse("String '***12435+34569-12345*10+50' should not be valid", App.errorChecking("***12435+34569-12345*10+50"));
        assertFalse("String '10**2' should not be valid", App.errorChecking("10**2"));
        assertFalse("String '12435+34569-12345*10+50*' should not be valid", App.errorChecking("12435+34569-12345*10+50*"));
        assertFalse("String '12435+34569-12345*10+50**' should not be valid", App.errorChecking("12435+34569-12345*10+50**"));

        // Checking for characters that are not numbers 0-9 or operators +, -, *, /.
        assertFalse("String '10*2a' should not be valid", App.errorChecking("10*2a"));
        assertFalse("String '10/2c' should not be valid", App.errorChecking("10/2c"));
        assertFalse("String '10+2b' should not be valid", App.errorChecking("10+2b"));
        assertFalse("String '10-2d' should not be valid", App.errorChecking("10-2d"));

        assertFalse("String 'e10*2' should not be valid", App.errorChecking("e10*2"));
        assertFalse("String 'f10/2' should not be valid", App.errorChecking("f10/2"));
        assertFalse("String 'g10+2' should not be valid", App.errorChecking("g10+2"));
        assertFalse("String 'h10-2' should not be valid", App.errorChecking("h10-2"));

        assertFalse("String '10i*2' should not be valid", App.errorChecking("10i*2"));
        assertFalse("String '10j/2' should not be valid", App.errorChecking("10j/2"));
        assertFalse("String '10k+2' should not be valid", App.errorChecking("10k+2"));
        assertFalse("String '10l-2' should not be valid", App.errorChecking("10l-2"));

        assertFalse("String '10*m2' should not be valid", App.errorChecking("10*m2"));
        assertFalse("String '10/n2' should not be valid", App.errorChecking("10/n2"));
        assertFalse("String '10+o2' should not be valid", App.errorChecking("10+o2"));
        assertFalse("String '10-p2' should not be valid", App.errorChecking("10-p2"));

        assertFalse("String '1q0*2' should not be valid", App.errorChecking("1q0*2"));
        assertFalse("String '1r0/2' should not be valid", App.errorChecking("1r0/2"));
        assertFalse("String '1s0+2' should not be valid", App.errorChecking("1s0+2"));
        assertFalse("String '1t0-2' should not be valid", App.errorChecking("1t0-2"));

        assertFalse("String '1uy0*2' should not be valid", App.errorChecking("1uy0*2"));
        assertFalse("String '1vz0/2' should not be valid", App.errorChecking("1vz0/2"));
        assertFalse("String '1wy0+2' should not be valid", App.errorChecking("1wy0+2"));
        assertFalse("String '1xz0-2' should not be valid", App.errorChecking("1xz0-2"));

        assertFalse("String '1q0*2' should not be valid", App.errorChecking("1q0*2"));
        assertFalse("String '1r0/2' should not be valid", App.errorChecking("1r0/2"));
        assertFalse("String '1s0+2' should not be valid", App.errorChecking("1s0+2"));

        assertFalse("String ' ' should not be valid", App.errorChecking(" "));

    }
}
