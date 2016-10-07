package Recursion;


import util.Printer;

/**
 * CSCI-UA.0310-001/002 Basic Algorithms Fall 2016
 * Homework 3
 * Problem 3-3 - Rotation Sorted Arrays
 *
 * a) [4 points]
 * To prove that if A is rotation-sorted, then one of A[0...(n/2-1)] and A[n/2...(n-1)] is fully sorted.
 *      Answer:
 *     [2 pts] 1)   When c < n/2, then A[0...(n/2-1)] is sorted.
 *                  Because A[0...(n/2-1)] only have the consecutive n/2 elements in B, that are B[c...(c+n/2)].
 *                  Since when c <n/2;
 *                      k = c + n/2 < n/2 + n/2 = n,
 *                  B[c...k] are consecutive sorted elements.
 *   [0.5 pts] 2)   When c >= n/2, proof is similar to 1).
 *
 *
 * [1.5 pts for either one correct answer or both]
 * What determines which one of the two halves is sorted?
 *      Answer:
 *             case 1: c > 0 and c < n/2
 *                      first half of A is sorted
 *             case 2: c > n/2 and c < n
 *                      second half of A is sorted
 *
 * Under what condition both halves of A are sorted?
 *      Answer:
 *             when c = 0 or n/2
 *
 */
public class RotationSortedArrays {

    private int[] A;
    private int[] B;
    private int c;

    public RotationSortedArrays(int[] B, int c){
        this.B = B;
        int arrLen = this.B.length;
        this.A = new int[B.length];
        for(int i=0;i<arrLen;i++){
            A[i] = B[(i + c)%arrLen];
        }
    }

    /**
     * b) Assume rotation-sorted A, without given cyclic shift value c.
     *
     * Divide-And-Conquer Algo to find min(A)
     *      Call function rotationSortedMin(A, 0, n-1)
     *      Pseudocode:
     *          Function rotationSortedMin(A, i, j)
     *              if i == j
     *                  return a[i]
     *              if A[i] > A[(i + j - 1)/2]
     *                  return rotationSortedMin(A, i, (i+j-1)/2)
     *              else if A[(i+j+1/2)] > A[j]
     *                  return rotationSortedMin(A, A[(i+j+1)/2], j)  {3 pts}
     *              else
     *                  return min(A[i], A[(i+j+1)/2]  {1 pts}
     *
     * Proof the correctness.
     *      Because A array goes increasingly in order until it 'falls off the cliff'.
     *      The min(A) value appears when 'falls off the cliff'.
     *      If there is no cliff, A[0] is the minimum value.
     *      Hence,
     *          when A[0] > A[n/2-1], cliff is in the first half
     *          when A[n/2] > A[n-1], cliff is in the second half.   {2 pts}
     *          OR, if both of above cases are not happening,
     *              it's either when c = 0, or when c = n/2,
     *                  which means min(A) is either A[0] or A[n/2]    {1 pt}
     *
     * [2 pts]
     * recurrence equation for its running time
     *      T(n) = T(n/2) + O(1)
     *      Hence T(n) is O(log n).
     *          O(log n) is faster than O(n).
     *
     */
    public int rotationSortedMin(int[] A, int index_start, int index_end){
        if( index_start == index_end ){
            return A[index_start];
        }
        if(A[index_start] > A[(index_start + index_end - 1)/2]){
            return rotationSortedMin(A, index_start, (index_start + index_end - 1)/2);
        }
        else if(A[(index_start + index_end + 1)/2] > A[index_end]){
            return rotationSortedMin(A, (index_start + index_end + 1)/2, index_end);
        }
        else{
            return Math.min(A[index_start], A[(index_start + index_end + 1)/2]);
        }
    }

    /**
     * Typical Student Answer - 1
     * Not a Divide-And-Conquer Approach.
     */
    public int rotationSortedMin2(int[] A, int start, int end){
        if (start == end)
            return A[start];
        int min = rotationSortedMin2(A, start, end-1);
        if( min < A[end])
            return min;
        else
            return A[end];
    }

    /**
     * Typical Student Answer - 2
     */
    public int rotationSortedMin3(int[] arr, int low, int high){
        if( high < low)
            return arr[0];
        if (high == low)
            return arr[low];
        int  mid = low + (high - low)/2;
        if (mid < high && arr[mid + 1] < arr[mid])
            return arr[mid+1];
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
        if (arr[high] > arr[mid])
            return rotationSortedMin3(arr, low, mid - 1);
        return rotationSortedMin3(arr, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] B = {1,2,3,4,5};
        int c = 1;
        RotationSortedArrays rotationSortedArrays = new RotationSortedArrays(B, c);
        System.out.println(Printer.printIntArray(rotationSortedArrays.B));
        System.out.println(Printer.printIntArray(rotationSortedArrays.A));

        int[] test1 = {1,2,3,4,5,6};
        int[] test2 = {4,5,6,1,2,3};
        int[] test3 = {2,3,4,5,6,1};
        System.out.println(rotationSortedArrays.rotationSortedMin(test1, 0, test1.length-1));
        System.out.println(rotationSortedArrays.rotationSortedMin(test2, 0, test2.length-1));
        System.out.println(rotationSortedArrays.rotationSortedMin(test3, 0, test3.length-1));

        int[] test4 = {3,5,1,2,2};
        System.out.println(rotationSortedArrays.rotationSortedMin2(test4, 0, test4.length-1));

        int[] test5 = {2,3,4,5,6,1};
        System.out.println(rotationSortedArrays.rotationSortedMin3(test5, 0, test5.length-1));
    }


}
