package InterviewQuiz;

import java.util.*;

// 第二题是给一个简单的运算表达式(比如 1+1*2), 算出结果。不用考虑括号。
public class Zillow_SimpleOperationExpression {

    public static int evaluate(String expression){
        List<String> tokens = analyzeExpression(expression);

        Deque<Integer> valueStack = new LinkedList<>();
        Deque<String>  operationStack = new LinkedList<>();

        for(int i=0; i<tokens.size(); i++){
            String currentToken = tokens.get(i);
            // if is operation: +, -, *, /
            if(currentToken.equals("+") || currentToken.equals("-")){
                operationStack.push(currentToken);
            }else if(currentToken.equals("*") || currentToken.equals("/")){
                // 1. pop previous valueStack
                int valS = valueStack.pollLast();
                // 2. get next value, move cursor accordingly
                int nextVal = Integer.valueOf(tokens.get(++i)); // must be a value, for valid expression
                // 3. do the multiplication/division, push back to valueStack
                if(currentToken.equals("*")){
                    valueStack.offerLast(valS*nextVal);
                }else{ // division
                    valueStack.offerLast(valS / nextVal);
                }
            }else{ // if is number
                valueStack.offerLast(Integer.valueOf(currentToken));
            }
        }

        // now we have two stacks with only +/-, do the simple math.
        while(!operationStack.isEmpty()){
            String op = operationStack.pop();
            int  val1 = valueStack.pollFirst();
            int  val2 = valueStack.pollFirst();// check error!
            int newVal = 0;
            if(op.equals("+")){
                newVal = val1 + val2;
            }else if(op.equals("-")){
                newVal = val1 - val2;
            }
            valueStack.offerFirst(newVal);
        }

        return valueStack.pollFirst();
    }

    private static List<String> analyzeExpression(String expression) {
        HashSet<Character> operationSet = new HashSet<>();
        operationSet.add('+');
        operationSet.add('-');
        operationSet.add('*');
        operationSet.add('/');

        List<String> list = new LinkedList<>();
        int l = 0;
        int r = 0;
        while(r < expression.length()){
            if(operationSet.contains(expression.charAt(r))){
                list.add(expression.substring(l, r)); // java substring
                list.add(expression.substring(r, r+1));
                l = r+1;
                r++;
            }else{
                r++;
            }
        }
        list.add(expression.substring(l, expression.length()));
        return list;
    }

    public static void main(String[] args) {
        String expression = "12+1*23*0-12+1*23-1+14/2";
        int result = evaluate(expression);
        System.out.println(result);
    }
}
