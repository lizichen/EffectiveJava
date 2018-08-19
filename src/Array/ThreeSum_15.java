package Array;

import java.util.*;

/**
 * Must review!
 */
public class ThreeSum_15 {
    // 1.
    // combine with two-sum
    // hashset to remove duplicates
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)
            return null;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList();

        HashSet uniqueSet = new HashSet();

        for(int i=0; i<nums.length-2; i++){
            List<Integer> oneResult = find(nums, i, -nums[i]);
//            Collections.sort(oneResult);
            if(oneResult != null && uniqueSet.add(oneResult)){
                result.add(oneResult);
            }
        }

        return result;
    }

    public static List<Integer> find(int[] nums, int startIndex, int target){
        // first find the two numbers
        HashMap<Integer, Integer> table = new HashMap();

        int first = 0;
        int second = 0;
        boolean found = false;
        for(int i=startIndex+1; i<nums.length; i++){
            first = target - nums[i];
            if(table.containsKey(first)){
                second = nums[i];
                found = true;
                break;
            }else{
                table.put(nums[i], target-nums[i]);
            }
        }

        if(found){
            return Arrays.asList(nums[startIndex], first, second);
        }else{
            return null;
        }
    }

    // 2.
    // use two pointers


    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        threeSum(arr);
    }
}
