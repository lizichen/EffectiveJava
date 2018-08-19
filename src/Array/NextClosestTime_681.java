package Array;

import java.util.Arrays;

public class NextClosestTime_681 {

    public static String nextClosestTime(String time) {

        int[] digits = new int[4];
        digits[0] = time.charAt(0) - (int)'0';
        digits[1] = time.charAt(1) - (int)'0';
        digits[2] = time.charAt(3) - (int)'0';
        digits[3] = time.charAt(4) - (int)'0';

        int minute = digits[2]*10 + digits[3];
        int hour = digits[0]*10 + digits[1];

        Arrays.sort(digits);

        int m = validNumberMinute(digits, minute);
        int h = validNumberHour(digits, hour);

        //10:59 is a special case
        if(m != 59){
            // simply return x
            return String.valueOf(hour)+":"+String.valueOf(m);
        }else if(minute == 59 && hour == 10){
            return "11:00";
        }else if(h != 23 && h != 24){ // if exist valid number hour < y < 24
            return String.valueOf(h)+":"+String.valueOf(minute);
        }else{ // else find the smallest number possible, implies the earliest time next day
            return String.valueOf(digits[0])+String.valueOf(digits[0])+":"+String.valueOf(digits[0])+String.valueOf(digits[0]);
        }
    }

    public static int validNumberMinute(int[] digits, int minute){
        if(minute == 59)
            return 59;
        else{
            int closeNext = 100;
            for(int i=0; i<digits.length; i++){
                for(int j=0; j<digits.length; j++){
                    if(minute < (digits[i]*10+digits[j]) && (digits[i]*10+digits[j]) < 60){
                        closeNext = Math.min(closeNext, (digits[i]*10+digits[j]));
                    }
                }
            }
            return closeNext;
        }
    }

    public static int validNumberHour(int[] digits, int hour){
        if(hour == 23)
            return 23;
        else{
            int closeNext = 24;
            for(int i=0; i<digits.length; i++){
                for(int j=0; j<digits.length; j++){
                    if(hour < (digits[i]*10+digits[j]) && (digits[i]*10+digits[j]) < 24){
                        closeNext = Math.min(closeNext, (digits[i]*10+digits[j]));
                    }
                }
            }
            return closeNext;
        }
    }

    public static void main(String[] args) {

        System.out.println(nextClosestTime("19:59"));
        System.out.println(nextClosestTime("11:59"));
        System.out.println(nextClosestTime("05:55"));
        System.out.println(nextClosestTime("09:23"));
    }
}
