package util;

/**
 * Created by lizichen1 on 9/29/16.
 */
public class Evaluator {

    public static final String OP_ADD = "+";
    public static final String OP_MINUS = "-";
    public static final String OP_DIV = "/";
    public static final String OP_MULTI = "*";


    public static String eval(String operator, String int_1, String int_2){
        int int_a = Integer.valueOf(int_1);
        int int_b = Integer.valueOf(int_2);
        String returnString = "";
        switch (operator){
            case OP_ADD:
                returnString =  String.valueOf(int_a + int_b); break;
            case OP_MINUS:
                returnString = String.valueOf(int_a - int_b); break;
            case OP_MULTI:
                returnString = String.valueOf(int_a * int_b); break;
            case OP_DIV:
                returnString = String.valueOf((int)(int_a/int_b)); break;
        }
        return returnString;
    }

    public static boolean isOperator(String input) {
        if (input.equals(OP_ADD) || input.equals(OP_MINUS) || input.equals(OP_DIV) || input.equals(OP_MULTI)) {
            return true;
        } else {
            return false;
        }
    }

}
