package StackNQueue;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1_496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>(); // for nums2,
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< nums2.length; i++){
            if(stack.isEmpty()){
                stack.push(nums2[i]);
            }else{
                while(!stack.isEmpty() && nums2[i] > stack.peek()){
                    map.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return  result;
    }

    public static void main(String[] args) {
        NextGreaterElement1_496 t = new NextGreaterElement1_496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        //Output: [-1,3,-1]
        t.nextGreaterElement(nums1, nums2);


    }
}
