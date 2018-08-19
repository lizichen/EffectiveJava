package Array;

import java.util.Arrays;

public class ThreeSumSmaller_259 {

    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length - 2; i++){
            int j = i+1;
            int k = nums.length - 1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] < target){
                    count += (k - j);
                    j++;
                }else{
                    k--;
                }
            }
        }
        return count;
    }

    public static int threeSumSmaller2(int[] nums, int target){
        int L = nums.length;
        Arrays.sort(nums);

        int count = 0;

        for(int i=0; i<L-2; i++) {
            int lo = i+1;
            int hi = L-1;

            while(lo<hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    count += hi-lo;
                    lo++;
                }
                else
                    hi--;
            }
        }
        return count;
    }

    public static boolean isValid(int i, int j, int k, int target){
        if(i + j + k < target){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        threeSumSmaller(new int[]{-2,0,1,3}, 2);
    }
}
