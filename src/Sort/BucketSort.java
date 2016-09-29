package Sort;

import LinkedList.SortedSinglyList;
import util.Printer;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class BucketSort {
    /**
     * Divider = Ceil( (MaxValueInTheArray + 1)/BucketSize )
     *
     * BucketIndex = Floor( Array[i] / Divider )
     */

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] arr1 = {1,9,0,4,7,2,3,3,6,2,5,3};

        bucketSort.sort(arr1);
        System.out.println(Printer.printIntArray(arr1));
    }

    public void sort(int[] arr){
        int arrLen = arr.length;
        int bucketSize = 10;
        // Create an array of SortedSinglyList
        SortedSinglyList[] buckets = new SortedSinglyList[bucketSize];
        for(int i=0;i<bucketSize;i++){
            buckets[i] = new SortedSinglyList();
        }
        int max = maxInt(arr);
        int divider = (int) Math.ceil( (max + 1) / bucketSize);

        // Assign values from arr to the buckets
        for(int i=0;i<arr.length;i++){
            int bucketIndex = Math.floorDiv(arr[i], divider);
            buckets[bucketIndex].push(arr[i]);
        }

        // Pop values from buckets one by one back to arr
        int arrIndex = arrLen-1;
        for(int i=bucketSize-1;i>=0;i--){
            while(buckets[i].getSize()>0){
                arr[arrIndex--] = buckets[i].pop().getValue();
            }
        }
    }

    public int maxInt(int[] arr){
        int max = arr[0];
        for(int i=1 ; i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
