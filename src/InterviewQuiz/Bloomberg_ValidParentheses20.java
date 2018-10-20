package InterviewQuiz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.


 */
public class Bloomberg_ValidParentheses20 {

    HashSet<Character> leftBrackets = new HashSet<>();
    HashMap<Character, Character> rightToLeft = new HashMap<>();

    Bloomberg_ValidParentheses20(){
        // initialize leftBracket hashset:
        leftBrackets.add('(');
        leftBrackets.add('[');
        leftBrackets.add('{');

        rightToLeft.put(')', '(');
        rightToLeft.put(']', '[');
        rightToLeft.put('}', '{');
    }

    public boolean isValid(String s){
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : arr){
            if(leftBrackets.contains(c)){
                stack.push(c);
            }else if(rightToLeft.containsKey(c)){
//                char right = c;
                if(stack.pop() != rightToLeft.get(c)){
                    return false;
                }
            }else{
                System.out.println("Warning! input is invalid character!");
                return false;
            }
        }

        if(stack.size() != 0)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        String testCase = "()[]";
        Bloomberg_ValidParentheses20 t = new Bloomberg_ValidParentheses20();
        System.out.println(t.isValid(testCase));
    }
}
