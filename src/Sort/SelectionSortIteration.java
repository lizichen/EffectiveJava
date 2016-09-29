package Sort;

import util.Printer;

/**
 * Created by lizichen1 on 9/20/16.
 */
public class SelectionSortIteration {

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,3,5,4,6};
        SelectionSortIteration selectionSortIteration = new SelectionSortIteration();
        selectionSortIteration.ascendingSort(arr);
        System.out.println(Printer.printIntArray(arr));
        selectionSortIteration.descendingSort(arr);
        System.out.println(Printer.printIntArray(arr));
    }

    public void ascendingSort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length ; j++ ){
                if( arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public void descendingSort(int arr[]){
        for(int i = 0; i<arr.length ;i++){
            int maxIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
