package BinarySearch;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//
// medium
//
// pay attention to the begining and ending of the index

public class SearchInRotatedArray_33 {

    public static int search(int[] nums, int target) {

        int start = 0;
        int end   = nums.length - 1;
        int mid   = nums.length/2;

        // zoom in close to the target
        while(start <= end){

            System.out.println("start\tmid\tend");
            System.out.println(start+"\t"+mid+"\t"+end);

            if(target == nums[mid]){
                return mid;
            }else if(nums[start] <= nums[mid]){
                if(target < nums[mid] && nums[start] <= target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(nums[mid] <= nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            mid = start + (end - start)/2;

        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));
    }
}
