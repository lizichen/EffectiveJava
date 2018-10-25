package Graph;

import java.util.Arrays;
import java.util.HashSet;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    public static int countComponents(int n, int[][] edges) {
        int[] arr = new int[n]; // index for node, value for parent
        // init arr with all -1
        for(int i=0; i<arr.length; i++)
            arr[i] = -1;

        for(int i=0; i<edges.length; i++){
            int parent = edges[i][0];
            int child  = edges[i][1];
            addToArr(arr, parent, child);
        }

        // find total unique numbers in arr:
        HashSet<Integer> uniqueNumbers = new HashSet();
        for(int i=0; i<arr.length; i++)
            uniqueNumbers.add(arr[i]);

        return uniqueNumbers.size();
    }

    public static void addToArr(int[] arr, int parent, int child){
        int childVal = arr[child];
        int parentVal = arr[parent];
        System.out.println(childVal+" "+parentVal);

        if(childVal == -1 && parentVal == -1){
            arr[parent] = parent;
            arr[child]  = parent;
        }else if(arr[parent] != -1 && arr[child] == -1){
            arr[child] = arr[parent];
        }else if(arr[parent] == -1 && arr[child] != -1){
            arr[parent] = arr[child];
        }else{
            for(int i=0; i<arr.length; i++){
                System.out.println("arr["+i+"]");
                if(arr[i] == childVal){
                    arr[i] = parentVal;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int t = 7;
        int[][] arr = {{0,1},{1,2},{3,4},{4,1},{5,6}};
        System.out.println("Number of connected components = "+countComponents(t, arr));
    }
}
