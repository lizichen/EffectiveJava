package InterviewQuiz;

//Given array first strictly decreasing, then strictly increasing. Find the target number.

public class Bloomberg_ArrayUpAndDown {

    public static int findTargetIndex(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(target == arr[mid])
                return mid;

            if(arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]){ // mid - 1 < mid < mid + 1
                if(target > arr[mid]){
                    left = mid;
                }else{
                    right = mid;
                }
            }else if(arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]){ // mid - 1 > mid > mid + 1
                if(target > arr[mid]){
                    right = mid;
                }else{
                    left  = mid;
                }
            }else{ // mid - 1 < mid > mid + 1
                if(target > arr[mid]) // does not exist
                    return -1;
                else if(target < arr[left]){
                    left = mid;
                }else if(target < arr[right]){
                    right = mid;
                }else{
                    right = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,8,9,3,2,1};
        int target = 2;
        System.out.println(findTargetIndex(arr, target));
    }
}
