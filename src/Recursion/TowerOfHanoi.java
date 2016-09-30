package Recursion;

import java.util.Stack;

/**
 * Created by lizichen1 on 9/30/16.
 */
public class TowerOfHanoi {

    private Stack<String> pole_A;
    private Stack<String> pole_B;
    private Stack<String> pole_C;

    public TowerOfHanoi(String[] newRings){
        this.pole_A = new Stack();
        this.pole_B = new Stack();
        this.pole_C = new Stack();
        int numberOfRings = newRings.length;
        for(int i=numberOfRings-1;i>=0;i--){
            this.pole_A.push(newRings[i]);
        }
        printAllStacks();
    }

    private void process(){
        ToH(this.pole_A.size(), this.pole_A, this.pole_B, this.pole_C);
    }

    private void ToH(int numberOfRingsToMove, Stack<String> fromPole, Stack<String> destPole, Stack<String> bufPole){
        if(numberOfRingsToMove == 1){
            move(fromPole, destPole);
        }else{
            ToH(numberOfRingsToMove-1, fromPole, bufPole, destPole);
            move(fromPole, destPole);
            ToH(numberOfRingsToMove-1, bufPole, destPole, fromPole);
        }
    }

    private void move(Stack from, Stack to){
        to.push(from.pop());
        printAllStacks();
    }

    private void printAllStacks(){
        System.out.println(this.pole_A.toString());
        System.out.println(this.pole_B.toString());
        System.out.println(this.pole_C.toString());
        System.out.println();
    }

   public static void main(String[] args) {
        String[] rings = {"a", "b", "c", "d", "e"};
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(rings);
        towerOfHanoi.process();
    }
}
