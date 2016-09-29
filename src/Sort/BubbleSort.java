package Sort;

import util.Printer;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1,9,0,4,7,-2,3,3,6};
        bubbleSort.bubbleSort(arr);
        System.out.println(Printer.printIntArray(arr));
    }

    public void bubbleSort(int[] arr){
        int arrLength = arr.length;
        int temp;
        for(int i = 0 ; i < arrLength-1 ; i++){
            for(int j=i+1 ; j < arrLength ; j++){
                if(arr[j] < arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



}
