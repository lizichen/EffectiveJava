package BinarySearch;

// https://leetcode.com/problems/sqrtx/description/
public class Sqrt_69 {
    public static int mySqrt(int x) {

        // Review: corner case:
        if(x <= 1)
            return 1;

        int left  = 0;
        int right = x;

        while(true){
            int mid = left + (right - left)/2;
            if(mid > x / mid){
                right = mid - 1;
            }else if( mid + 1 > x / (mid + 1)){
                return mid;
            }else{
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(15));
    }
}
