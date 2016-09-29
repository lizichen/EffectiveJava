package Sort;

import util.Printer;

/**
 * Created by lizichen1 on 9/26/16.
 * http://www.algolist.net/Algorithms/Sorting/Insertion_sort
 */
public class InsertionSort {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr1 = {1,9,0,4,7,-2,3,3,6};
        int[] arr2 = {1,9,0,4,7,-2,3,3,6};

        insertionSort.sort(arr1);
        System.out.println(Printer.printIntArray(arr1));

        insertionSort.recursiveSort(arr2,0);
        System.out.println(Printer.printIntArray(arr2));
    }

    public void sort(int[] arr){
        int arrLen = arr.length;
        for(int i=0 ; i<arrLen ; i++){
            for(int j=i;j>0;j--){
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public void recursiveSort(int[] arr, int index){
        if(index < arr.length) {
            for (int j = index; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            recursiveSort(arr, index+1);
        }
    }


}
