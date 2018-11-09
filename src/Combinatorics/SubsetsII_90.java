package Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

    public static List<List<Integer>> subsets2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList(), nums, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        Subsets_78.logging(tempList);
        result.add(new ArrayList<>(tempList));
        for(int i=start; i<nums.length; i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i+1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,2};
        /** Expect:
         * []
         * [1 ]
         * [1, 2 ]
         * [1, 2, 2 ]
         * [2 ]
         * [2, 2 ]
         */
        subsets2(arr);
    }
}
