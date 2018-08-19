package Array;

public class MinimumSizeSubarraySum_209 {

    public static int minSubArrayLen(int s, int[] nums) {
        
        int sum = 0;
        int length = Integer.MAX_VALUE;
        int j = 0;

        for(int i=0; i<nums.length; i++){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            // now sum should be greater than s
            if(sum >= s){
                length = Math.min(length, j-i);
                sum -= nums[i];
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;

    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {7};
        System.out.println(minSubArrayLen(s, nums));
    }
}
