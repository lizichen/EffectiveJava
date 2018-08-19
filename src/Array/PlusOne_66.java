package Array;

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {

        for (int i=digits.length-1;i>=0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] oneMoreDigitArr = new int[digits.length];
        oneMoreDigitArr[0] = 0;

        return oneMoreDigitArr;
    }

    public static void main(String[] args) {
        plusOne(new int[]{1,2,3});
    }
}
