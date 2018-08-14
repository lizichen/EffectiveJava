package MathRelated;

import java.util.HashSet;

public class HappyNumber_202 {
    public static boolean isHappy(int n) {

        if(n == 1){
            return true;
        }

        HashSet<Integer> numbers = new HashSet();

        int val = n; //doTheMath(n);
        while(!numbers.contains(val)){
            numbers.add(val);
            val = doTheMath(val);
            if(val == 1){
                return true;
            }
        }
        return false;
    }

    public static int doTheMath(int n){

        int sum = 0;

        int digits = 0;
        int s = n/1;
        while(s > 0){
            digits++;
            s = s/10;
        }

        while(digits >= 1){
            int base = (int)Math.pow(10, digits-1);
            int temp = n/base;
            sum += temp*temp;
            n -= temp*base;
            digits--;
        }

        return sum;
    }

    public static void main(String[] args) {
        isHappy(19);
    }
}
