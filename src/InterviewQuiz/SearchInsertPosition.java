package InterviewQuiz;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 */

public class SearchInsertPosition {

    public static int searchInsert(int[] A, int target) {

        int length = A.length;
        int start = 0, end = length - 1;
        int mid = 0;
        int found = 0;

        if(length == 0)
            return 0;

        while(start < end){
            mid = start + (end - start) / 2;
            if(A[mid] < target)
                start = mid + 1;
            else if (A[mid] > target)
                end = mid + 1;
            else{// if (A[mid] == target)
                found = 1;
                break; //mid is the index
            }
        }
        return found == 1 ? mid : 0;
    }

    public static void main(String[] args)
    {
        int[] A = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(A, target));
    }

}
