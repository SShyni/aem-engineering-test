package com.adobe.assignment.aem.core.number.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.adobe.assignment.aem.core.number.impl.NumberException;
import com.adobe.assignment.aem.core.Constants;

public class NumberConversionTest{

    @Test
    void intToRomanNumeral() throws NumberException{

        String result = NumberConversion.intToRomanNumeral("10");
        assertEquals("X", result);

        result = NumberConversion.intToRomanNumeral("3999");
        assertEquals("MMMCMXCIX", result);

        result = NumberConversion.intToRomanNumeral("1");
        assertEquals("I", result);

        result = NumberConversion.intToRomanNumeral("255");
        assertEquals("CCLV", result);

    }

    @Test
    void intToRomanNumeralNegativeNum() throws NumberException{

        Throwable exception =  assertThrows(NumberException.class,() -> {
            NumberConversion.intToRomanNumeral("-10");
        } , "Input not in range" );

        assertEquals(exception.getMessage(), "Input must be in range of " + Constants.MIN_VALUE +" to " +Constants.MAX_VALUE);

    }

    @Test
    void intToRomanNumeralInvalidNum() throws NumberException{

        Throwable exception =  assertThrows(NumberException.class, () -> {
            NumberConversion.intToRomanNumeral("e+48");
        }, "Input must be a valid Integer");

        assertEquals(exception.getMessage(), "Input must be a valid Integer");

        assertThrows(NumberException.class,  () -> {
            NumberConversion.intToRomanNumeral("xmded");
        }, "Input must be a valid Integer");

        assertEquals(exception.getMessage(), "Input must be a valid Integer");

        assertThrows(NumberException.class,  () -> {
            NumberConversion.intToRomanNumeral(null);
        }, "Input must be a valid Integer");

        assertEquals(exception.getMessage(), "Input must be a valid Integer");
    }

    @Test
    void intToRomanNumeralOutOfRange() throws NumberException{

        Throwable exception =  assertThrows(NumberException.class, () -> {
            NumberConversion.intToRomanNumeral("4000");
        }, "4000 is not in range ");

        assertEquals(exception.getMessage(), "Input must be in range of " + Constants.MIN_VALUE +" to " +Constants.MAX_VALUE);

    }
}