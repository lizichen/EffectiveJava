package util;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lizichen1 on 9/28/16.
 */
public class Printer {

    public static String printIntArrayToString(int arr[]){
        StringBuilder returnValue = new StringBuilder();
        for (int i:arr) {
            returnValue.append(i);
            returnValue.append(" ");
        }
        return returnValue.toString();
    }

    public static <T> void printArray(T[] arr){
        StringBuilder returnValue = new StringBuilder();
        for (T i:arr) {
            returnValue.append(i.toString());
            returnValue.append(" ");
        }
        System.out.println(returnValue.toString());
    }

    public static void printIntArray(int arr[]){
        System.out.println(printIntArrayToString(arr));
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
