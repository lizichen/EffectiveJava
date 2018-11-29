package InterviewQuiz;

import util.Printer;

import java.util.ArrayList;
import java.util.List;

// [[0, 1], [2, 3, 4, 5], [6]] 要 Merge 成 [0, 2, 6, 1, 3, 4, 5]
//  0, 2, 6
//  1, 3
// 4, 5
public class Zillow_SequentialMerge {

    public static void merge(int[][] arr){
        List<Integer> result = new ArrayList<>();

        int[] cursor = new int[arr.length]; // 0, 0, 0
        boolean addedSth = true;

        while(addedSth){
            addedSth = false;
            for(int i=0; i<arr.length; i++){
                if(cursor[i] < arr[i].length){
                    result.add(arr[i][cursor[i]]); // the cursor[i]-th element into the result
                    cursor[i]++;
                    addedSth = true;
                }
            }
        }

        Printer.printList(result);
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{
                {0,1},
                {2,3,4,5},
                {6},
                {7,8,9},
                {10}
        };
        merge(m);
    }
}
