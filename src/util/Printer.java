package util;

import java.util.HashMap;
import java.util.List;

import static javafx.scene.input.KeyCode.K;

/**
 * Created by lizichen1 on 9/28/16.
 */
public class Printer {

    public static String printIntArray(int arr[]){
        String returnValue = "";
        for (int i:arr) {
            returnValue += (i+" ");
        }
        return returnValue;
    }

    public static String printIntArray(int arr[], int endIndex){
        String returnValue = "";
        for (int i=0;i<=endIndex;i++) {
            returnValue += (arr[i]+" ");
        }
        return returnValue;
    }

    public static <K,V> String printHashMap(HashMap<K, V> map){
        StringBuilder returnString = new StringBuilder();

        for(K key : map.keySet()){
            returnString.append(key + " : " +map.get(key)+"\n");
        }

        return returnString.toString();
    }

    public static <K> void printList(List<K> list){
        if(list == null){
            System.out.println("Warning! List is null!");
        }else if(list.size() == 0){
            System.out.println("Warning! List is empty!");
        }else{
            for (K e : list){
                System.out.println(e.toString());
            }
        }
    }
}
