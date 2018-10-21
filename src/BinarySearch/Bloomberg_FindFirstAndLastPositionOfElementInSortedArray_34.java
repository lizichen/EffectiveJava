package BinarySearch;

public class Bloomberg_FindFirstAndLastPositionOfElementInSortedArray_34 {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if(nums == null || nums.length == 0)
            return result;

        int leftIdx = searchLeft(nums, target);
        int rightIdx = searchRight(nums, target);
        System.out.println(leftIdx);
        System.out.println(rightIdx);

        if(leftIdx >= 0 && rightIdx >= 0 && nums[leftIdx] == target && nums[rightIdx] == target && leftIdx <= rightIdx){
            result[0] = leftIdx;
            result[1] = rightIdx;
        }

        return result;
    }

    public static int searchLeft(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;

        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(target <= nums[mid]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int searchRight(int[] nums, int target){
        int lo = 0;
        int hi = nums.length-1;

        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(target < nums[mid]){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }

        return hi-1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2};
        int target = 2;
        int[] result = searchRange(arr, target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}
