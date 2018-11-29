package StackNQueue;

import util.Printer;

import java.util.Stack;

public class DailyTemperature_739 {

    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
             //expect: [1, 1, 4, 2, 1, 1, 0, 0].

        Printer.printIntArray(dailyTemperatures(input));
    }
}
