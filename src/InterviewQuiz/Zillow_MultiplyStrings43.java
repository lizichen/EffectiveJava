package InterviewQuiz;

import java.util.Arrays;

public class Zillow_MultiplyStrings43 {

    public static String multiply(String num1, String num2){
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m+n];

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mul + pos[p2];

                pos[p1] += sum/10;
                pos[p2] = sum % 10;
            }
        }

        System.out.println(Arrays.toString(pos));

        return "";
    }

    public static void main(String[] args) {
        multiply("12","34");
    }
}
