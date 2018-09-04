package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {

    // Leetcode user solution 1
    public static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }

    // Leetcode user solution 2
    public boolean canPartition3(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }

    public static boolean canPartition2(int[] nums) {
        if(nums.length <= 1)
            return false;

        int sum = 0;
        for(int n: nums){
            sum += n;
        }

        if(sum % 2 != 0)
            return false;

        sum = sum/2;

        boolean[] possibleCombination = new boolean[sum+1];
        possibleCombination[0] = true;

        for(int n: nums){
            for(int i=possibleCombination.length-1; i>=n; i--){
                possibleCombination[i] = (possibleCombination[i - n] == true);
            }
        }

        return possibleCombination[sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition2(new int[]{3,6,2,1}));
    }
}
