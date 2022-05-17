package bench.cpu;

import java.util.Arrays;

public class DigitsOfPiSpigot {

    private int[] digits;
    private String PIdigits = "";
    private String Helper = "";
    public StringBuilder predigits = new StringBuilder();
    private StringBuilder myString;
    public String toDisplay = "";


    // Allocate digits[]
    public boolean init(int k) {
        int array_size_needed = k * 10 / 3 + 1;
        digits = new int[array_size_needed];
        if (digits == null) {
            System.err.printf("Failed to allocate " + (array_size_needed*4)
                    + " bytes.");
            return false;
        }

        // fill each digit with a 2
        for (int i=0; i < digits.length; i++)
            digits[i] = 2;

        return true;
    }


    // Produce digits
    public void Digits(int k) {
        if (!init(k)) return;

        for (int iter = 0; iter < k; iter++) {

            // Work backwards through the array, multiplying each digit by 10,
            // carrying the excess and leaving the remainder.
            int carry = 0;
            for (int i=digits.length-1; i > 0; i--) {
                int numerator = i;
                int denomenator = i * 2 + 1;
                int tmp = digits[i] * 10 + carry;
                digits[i] = tmp % denomenator;
                carry = tmp / denomenator * numerator;
            }

            // process the last digit
            int tmp = digits[0] * 10 + carry;
            digits[0] = tmp % 10;
            int digit = tmp / 10;

            // implement buffering and overflow
            if (digit < 9) {
                flushDigits();
                // print a decimal after the leading "3"
                if (iter == 1) {
                    toDisplay += ".";
                    //System.out.print(".");
                }
                addDigit(digit);
            } else if (digit == 9) {
                addDigit(digit);
            } else {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
            // System.out.flush();
        }
        flushDigits();
        System.out.println();
        //System.out.println(toDisplay);
    }





    // write the buffered digits
    void flushDigits() {
        toDisplay += predigits;
        //System.out.append(predigits);
        predigits.setLength(0);
    }


    // given an integer 0..9, buffer a digit '0' .. '9'
    void addDigit(int digit) {
        predigits.append((char)('0' + digit));
    }


    // add one to each digit, rolling over from from 9 to 0
    void overflowDigits() {
        for (int i=0; i < predigits.length(); i++) {
            char digit = predigits.charAt(i);
            // This could be implemented with a modulo, but compared to the main
            // loop this code is too quick to measure.
            if (digit == '9') {
                predigits.setCharAt(i, '0');
            } else {
                predigits.setCharAt(i, (char)(digit + 1));
            }
        }
    }
}



