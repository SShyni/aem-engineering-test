package com.adobe.assignment.aem.core.number.util;

import com.adobe.assignment.aem.core.Constants;
import com.adobe.assignment.aem.core.number.impl.NumberException;

public class NumberConversion{

    static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static final String[] SYMBOLS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    /**
     * This menthod takes a string number and returns a roman number
     * @param num
     * @return
     * @throws NumberException
     */
	public static String intToRomanNumeral(String num) throws NumberException{
        StringBuilder romanNumeral = new StringBuilder();
	    try {
            int number = Integer.parseInt(num);
            if (number < Constants.MIN_VALUE || number > Constants.MAX_VALUE) {
                throw new NumberException("Input must be in range of " + Constants.MIN_VALUE +" to " +Constants.MAX_VALUE);
            }
            for (int i = 0; i < VALUES.length; i++) {
                if (number < 0) break;

                while (VALUES[i] <= number) {
                    number -= VALUES[i];
                    romanNumeral.append(SYMBOLS[i]);
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberException("Input must be a valid Integer");
        }
        return romanNumeral.toString();
    }

}