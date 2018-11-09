package Combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        backtrack(result, new ArrayList(), nums, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        logging(tempList);
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    protected static void logging(List<Integer> list){
        StringBuilder sb = new StringBuilder("[");
        for(Integer l : list){
            sb.append(l+", ");
        }
        if(sb.length() > 2)
            sb.delete(sb.length() - 2, sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        /**Expectation:
         * []
         * [1 ]
         * [1, 2 ]
         * [1, 2, 3 ]
         * [1, 3 ]
         * [2 ]
         * [2, 3 ]
         * [3 ]
         */
        subsets(arr);
    }
}
