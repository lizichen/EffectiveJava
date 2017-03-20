package StackNQueue;

import java.util.Deque;
import java.util.LinkedList;
/**
 * Created by lizichen1 on 3/19/17.
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/#/description
 */
public class EvaluateReversePolishNotation_150 {
    public static int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();
        int last = 0;
        int second2Last = 0;
        for(int i=0;i<tokens.length;i++){
            switch (tokens[i]) {
                case "+":
                    last = stack.poll();
                    second2Last = stack.poll();
                    stack.push(last + second2Last);
                    break;
                case "-":
                    last = stack.poll();
                    second2Last = stack.poll();
                    stack.push(second2Last - last);
                    break;
                case "*":
                    last = stack.poll();
                    second2Last = stack.poll();
                    stack.push(last * second2Last);
                    break;
                case "/":
                    last = stack.poll();
                    second2Last = stack.poll();
                    stack.push(second2Last / last);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }
        return stack.poll();
    }

    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(a));
    }
}
