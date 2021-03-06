package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by lizichen1 on 3/19/17.
 *
 * https://leetcode.com/problems/two-sum/#/description
 */
public class TwoSum_1 {

    public int[] twoSum_forloop(int[] nums, int target) {
        if(nums.length < 2)
            return null;

        int residual;

        int index1 = -1;
        int index2 = -1;

        for(int i=0;i<nums.length;i++){
            residual = target - nums[i];
            index1 = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == residual){
                    index2 = j;
                    return new int[]{index1, index2};
                }
            }
        }
        return null;
    }

    public static int[] twoSum(int[] nums, int target) {

        int index1 = -1;
        int index2 = -1;

        Hashtable table = new Hashtable(); // <target - nums[i], indexOfi>

        for(int i=0;i<nums.length;i++){
            int dif = target - nums[i];
            if(table.get(dif) != null){
                index2 = i;
                index1 = (int) table.get(dif);
                break;
            }else{
                table.put(nums[i], i);
            }
        }

        return new int[]{index1, index2};
    }

    public static int[] twoSum_hashmap(int[] nums, int target) {

        int index1 = -1;
        int index2 = -1;

        HashMap table = new HashMap(); // <target - nums[i], indexOfi>

        for(int i=0;i<nums.length;i++){
            int dif = target - nums[i];
            if(table.get(dif) != null){
                index2 = i;
                index1 = (int) table.get(dif);
                break;
            }else{
                table.put(nums[i], i);
            }
        }

        return new int[]{index1, index2};
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum_hashmap(new int[]{2, 7, 11, 15}, 9)));
    }
}
