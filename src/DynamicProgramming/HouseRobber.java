package DynamicProgramming;

/*
Leetcode 198
 */

public class HouseRobber {

    public int rob(int[] nums) {
        // recursive method
        // return recur_helper(nums.length-1, nums);

        // iterative method
        return iter_helper(nums);
    }

    public static int recur_helper(int index, int[] nums){
        if(index < 0)
            return 0;

        int val_1 = nums[index] + recur_helper(index - 2, nums); // take current house
        int val_2 = recur_helper(index - 1, nums); // not take this house

        return (val_1 > val_2) ? val_1 : val_2;
    }

    public static int iter_helper(int[] nums){

        if(nums.length == 1)
            return nums[0];
        if(nums.length == 0)
            return 0;

        int previous = 0;
        int current = nums[0];
        int next = 0;

        for(int i=1; i<nums.length; i++){
            next = Math.max(current, nums[i] + previous);
            previous = current;
            current = next;
        }

        return current;
    }
}
