package Array;

import java.math.BigInteger;

public class TitleToNumber {

    public static String titleToNumber(String s) {

        char[] letters = s.toCharArray();
        // 'A' - 64 = 1
        // 'Z' - 64 = 26

        BigInteger sum = new BigInteger("0");
        int times = 0;
        BigInteger base = new BigInteger("26");

        for(int i=letters.length - 1; i>=0; i--){
            int val = letters[i] - 64; // 1 = A, 2 = B
            BigInteger valBig = new BigInteger(Integer.toString(val));

            // base.pow(times).;


            sum = sum.add( valBig.multiply(base.pow(times)) );
            // sum += ((int)Math.pow(26, times) * val);

            times++;
        }

        return sum.toString();
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AAA"));
    }

}
