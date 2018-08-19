package Array;

import java.util.Random;

// Has better solution
// https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
public class MultiplyStrings_43 {
    public static String multiply(String num1, String num2) {

        if((num1.length() == 1 && num1.charAt(0) == 48) || (num2.length() == 1 && num2.charAt(0) == 48) ){
            return "0";
        }

        String m1;
        String m2;

        // choose a num that has less digits for the multiplier
        if(num1.length() <= num2.length()){
            m1 = num2;
            m2 = num1;
        }else{
            m1 = num1;
            m2 = num2;
        }

        int len1 = m1.length();
        int len2 = m2.length();

        // for each iteration add the result to a sum
        String sum = "0";
        int base = 10; // base^0, base^1, ..., base^(m2.length - 1)
        int m2Idx = len2 - 1;

        while(m2Idx >= 0){
            // multiple m1 and m2.charAt(m2Idx)
            String oneResult = multipleOne(m1, m2.charAt(m2Idx) - 48, len2 - 1 - m2Idx);
            sum = AddStrings_415.addStrings(sum, oneResult);
            m2Idx--;
        }

        // convert the sum result to string and return
        return sum;
    }

    /**
     * @param m1 is the multiplicand, full string
     * @param num is the multiplier digit
     * @param zero tells how many 0 should be appended to the end of the result
     * @return
     */
    public static String multipleOne(String m1, int num, int zero){
        int carry = 0;
        int m1Idx = m1.length() - 1;

        StringBuilder sum = new StringBuilder();
        while(zero != 0){
            sum.append("0");
            zero--;
        }

        while(m1Idx >= 0){
            int newval = m1.charAt(m1Idx) - 48;

            newval = newval * num + carry;
            if(newval >= 10){
                carry = newval / 10;
                newval = newval % 10;
                newval = (newval == 0) ? 0 : newval;
            }else{
                carry = 0;
            }

            sum.insert(0, newval);
            m1Idx--;
        }

        if(carry != 0){
            sum.insert(0, carry);
        }

        return sum.toString();
    }


    public static void test(){
        Random rand = new Random();

        int n1 = rand.nextInt(10000);
        int n2 = rand.nextInt(10000);
        for(int i=0; i < 50000; i++){
            String result = multiply(String.valueOf(n1),String.valueOf(n2));
            if(n1*n2 != Integer.valueOf(result)){
                System.out.println("Error!");
                System.out.println(n1+" "+n2+"!="+result);
                System.exit(-1);
            }else{
                System.out.println("Good!");
            }
        }

        System.out.println("All Tests Passed!");
    }



    public static void main(String[] args) {
//        test();
//        System.out.println(multiply("123456789", "987654321")); //"121932631112635269"
//        9437 9625!=90832225
//        14169 42655!=605379705
//        4936 97945!=483458521
//        26004 9964!=259113856
//        3048 9880!=30114340

        System.out.println(multiply("3048", "9880"));



    }
}
