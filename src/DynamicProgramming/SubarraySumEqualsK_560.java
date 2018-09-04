package DynamicProgramming;

public class SubarraySumEqualsK_560 {

    // Problem: does not work for zero and negative target k.
    public static int subarraySum(int[] nums, int k) {

        int[] mark = new int[k+1];
        mark[0] = 0;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            sum += cur;
            for(int j=1; j<mark.length; j++){
                if(j == nums[i]){
                    mark[j]++;
                } else if(j > sum){
                    break;
                } else if(j - cur >= 0 && j - cur < mark.length && mark[j - cur] != 0){
                    mark[j]++;
                }
            }
        }

        return mark[k];
    }

    // solution 3 from leetcode; however, is WRONG!
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    // recursive approach:
    // only works for positive k
    public static int subarraySum3(int[] nums, int k){
        return recursiveHelper(nums, k, nums.length-1);
    }

    public static int recursiveHelper(int[] arr, int total, int lastIdx){
        if(total == 0) {
            return 1;
        } else if(total < 0) {
            return 0;
        } else if(lastIdx < 0) {
            return 0;
        } else if(total < arr[lastIdx]){
            return recursiveHelper(arr, total, lastIdx-1);
        } else{
            return recursiveHelper(arr, total, lastIdx - 1)
                    + recursiveHelper(arr, total - arr[lastIdx], lastIdx - 1);
        }
    }



    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,1,1}; int k = 5;
//        int[] arr = new int[]{28,54,7,-70,22,65,-6}; int k = 100;
        int[] arr = new int[]{2,4,6,10}; int k = 16;
        System.out.println(subarraySum3(arr, k));
    }
}
