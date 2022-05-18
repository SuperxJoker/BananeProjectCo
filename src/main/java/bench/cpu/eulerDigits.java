package bench.cpu;

public class eulerDigits {
    private int[] digits;
    public StringBuilder predigits = new StringBuilder();
    public String toDisplay="";

    // Allocate digits[]
    public boolean init(int k)
    {
        int array_size_needed = k * 10 / 3 + 1;
        digits = new int[array_size_needed];
        if (digits == null) {
            System.err.printf("Failed to allocate " + (array_size_needed*4) + " bytes.");
            return false;
        }

        for (int i=0; i < digits.length; i++)
            digits[i] = 1;

        return true;
    }

    public void EulerCalc(int numberOfDigits)
    {
        if (!init(numberOfDigits)) return;

        int N=numberOfDigits+9,x=0;
        digits[1]=2;
        digits[0]=0;
        predigits.append(2.7);
        while(N>9)
        {
            N--;
            int n=N;
            n--;
            while(n!=0) {

                digits[n]=x%n;
                x = 10 * digits[n-1] + x/n;
                n--;
            }
            if(N==numberOfDigits+9-1) continue;
            if (x<9) {
                flushDigits();
                addDigit(x);
            }
            else if(x == 9)
            {
                addDigit(x);
            }
            else
            {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
        }
    }

    void addDigit(int digit) {
        predigits.append((char)('0' + digit));
    }

    // write the buffered digits
    void flushDigits() {
        toDisplay += predigits;
        predigits.setLength(0);
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
