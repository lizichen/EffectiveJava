package Array;

/*
https://leetcode.com/problems/container-with-most-water/description/
 */

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {

        if(height.length <= 1)
            return 0;

        int max = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int currentArea = 0;

        while(leftIndex < rightIndex){
            currentArea = w(leftIndex, rightIndex) * h(leftIndex, rightIndex, height);
            if(height[leftIndex] < height[rightIndex]){
                leftIndex++;
            }else{
                rightIndex--;
            }
            max = Math.max(currentArea, max);
        }
        return max;
    }

    public static int w(int left, int right){
        return right - left;
    }

    public static int h(int l, int r, int[] height){
        return Math.min(height[l], height[r]);
    }
}
