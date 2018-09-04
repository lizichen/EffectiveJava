package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum_523 {

    public static boolean checkSubarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();//      sum      index
        int sum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            sum += cur;
            int reminder = k==0 ? sum : sum % k;
            if(map.containsKey(reminder)){
                int prevIdx = map.get(reminder);
                System.out.println("prevIdx = "+ prevIdx + " i = "+i);
                if(i - prevIdx > 1) {
                    return true;
                }
            }else{
                map.put(reminder, i);
            }
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0)
                runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                System.out.println("prev = "+ prev + " i = "+i);
                if (i - prev > 1) {
                    return true;
                }
            }
            else
                map.put(runningSum, i);
        }
        return false;
    }



    public static void main(String[] args) {
//        int[] arr = new int[]{24,2,4,6,7}; int target = 6;
//        int[] arr = new int[]{24,2,4,6,7}; int target = 0;
        int[] arr = new int[]{1,2}; int target = 2;
        System.out.println("my result: \t\t"+checkSubarraySum1(arr, target) + "\n");
        System.out.println("leetcode user solution: \t"+checkSubarraySum2(arr, target));
    }
}
