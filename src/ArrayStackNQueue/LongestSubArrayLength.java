package ArrayStackNQueue;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * Given an array a, we define the subarray of array to be a contiguous block of a's elements having a length that is less than or equal to the length of array a.
 *
 * Devise an algorithm that return the length of the longest subarray elements that sum to a sumber less than or equal to k.
 */
public class LongestSubArrayLength {

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,1,1,1,4,4,1,2,3,4,1};
        int k = 7;
        System.out.print("Max length = "+longestSubArrayLength(arr,k));
    }



    public static int longestSubArrayLength(int[] arr, int k){
        int resultLength = 0;
        int sum = 0;
        int j = 0;
        int i = 0;
        for( ; i< arr.length; i++){
            sum += arr[i];
            while(j <= i && sum > k){
                sum -= arr[j];
                j++;
            }
            if(sum <= k){
                resultLength = Math.max(resultLength, i - j + 1);
                System.out.println("resultLength = "+resultLength+" j = "+j+" i= "+i);
            }
        }
        return  resultLength;
    }
}
