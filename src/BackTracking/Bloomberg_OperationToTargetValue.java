package BackTracking;

import java.util.HashSet;

/**
 * Given a target value
 * return if it's possible to reach from 1 with unlimited operations of multiplication of 2 and division of 3.
 *
 * for example:
 *      target = 5
 *      return: true
 *      explanation: 1 * 2 * 2 * 2 * 2 / 3 = 5
 */
public class Bloomberg_OperationToTargetValue {

    public boolean canGetTarget(int target){
        HashSet<Integer> seen = new HashSet<>();
        return helper(1, target, seen);
    }

    public boolean helper(int current, int target, HashSet<Integer> seen){
        if(seen.contains(current))
            return false;

        seen.add(current);
//        System.out.println("current = "+current);

        if(current == target)
            return true;
        else if(current < target * 3){
            return helper(current * 2, target, seen);
        }else{
            return helper(current / 3, target, seen);
        }
    }

    public static void main(String[] args) {
        Bloomberg_OperationToTargetValue t = new Bloomberg_OperationToTargetValue();
        for(int i=1; i<20; i++)
            System.out.println("i = "+i+" -> "+t.canGetTarget(i));
    }
}
