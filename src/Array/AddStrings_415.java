package Array;

public class AddStrings_415 {

    public static String addStrings(String num1, String num2) {

        // use StringBuilder insert(0, str)
        StringBuilder result = new StringBuilder();

        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;

        int carry = 0;

        while(idx1 != -1 || idx2 != -1){
            int val1 = 0;
            int val2 = 0;
            int newval = 0;

            if(idx1 != -1){
                val1 = num1.charAt(idx1) - 48;
                idx1--;
            }

            if(idx2 != -1){
                val2 = num2.charAt(idx2)  - 48;
                idx2--;
            }

            if(val1 + val2 + carry >= 10){
                newval = val1 + val2 + carry - 10;
                carry = 1;
            }else{
                newval = val1 + val2 + carry;
                carry = 0;
            }

            result.insert(0, String.valueOf(newval));
        }

        if(carry == 1){
            result.insert(0, "1");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("5","5"));
    }
}
