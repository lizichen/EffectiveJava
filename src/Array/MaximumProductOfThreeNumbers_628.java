package Array;

public class MaximumProductOfThreeNumbers_628 {
    public static int maximumProduct(int[] nums) {
        // find the largest three numbers (three largest positives)
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        // find the smallest two numbers ( two smallest negatives)
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int n : nums){
            if(max1 <= n){
                max3 = max2;
                max2 = max1;
                max1 = n;
            }else if(max2 <= n && n < max1){
                max3 = max2;
                max2 = n;
            }else if(max3 <= n && n < max2){
                max3 = n;
            }

            if(n <= min1){ // min1 the smallest
                min2 = min1;
                min1 = n;
            }else if(min1 < n && n <= min2){ // min2 second smallest
                min2 = n;
            }
        }

        return Math.max((max1*max2*max3), max1*min1*min2);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1,-2,-3}));
    }
}
