package StackNQueue;

import static util.Evaluator.eval;
import java.util.Stack;
import static util.Evaluator.isOperator;

/**
 * Created by lizichen1 on 9/29/16.
 *
 * FA Course by A. Siegel Ex. 2.29 RPN Stack Processing a) iterative algorithm.
 * Assume input RPN is the correct arrangement.
 */
public class IterativeRPNStackProcessing {

    private Stack<String> S;
    private Stack<String> Y;
    String cursor_a = null;
    String cursor_b = null;

    public IterativeRPNStackProcessing(){
        this.S = new Stack();
        this.Y = new Stack();
    }

    private int evalStack(String[] toS){
        initializeStack_S(toS);
        while(!S.empty()){
            String sPop = this.S.pop();
            if(isOperator(sPop)){
                if(this.Y.size()>=2){
                    pushToY(eval(sPop, Y.pop(), Y.pop()));
                }
            }else{
                pushToY(sPop);
            }
        }
        return Integer.valueOf(this.Y.pop());
    }

    private void pushToY(String item){
        this.Y.push(item);
        if(Y.size()==1){
            cursor_a = null;
            cursor_b = Y.peek();
        }
        else {
            String tmp = cursor_b;
            cursor_a = tmp;
            cursor_b = cursor_a;
        }
    }

    private void initializeStack_S(String[] toS){
        for(int i=toS.length-1;i>=0;i--){
            this.S.push(toS[i]);
        }
    }

    public static void main(String[] args) {
        String[] stackoperands = {"1","2","3","4","+","5","*","-","/","6","+","7","8","-","+"};
        IterativeRPNStackProcessing iterativeRPNStackProcessing = new IterativeRPNStackProcessing();
        System.out.println("Result = "+iterativeRPNStackProcessing.evalStack(stackoperands));
    }
}
