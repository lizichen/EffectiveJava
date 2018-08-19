package Array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LongestSubStringWithoutRepeatedChar_3 {

    public static int lengthOfLongestSubstring2(String s){

        HashSet countingSet = new HashSet();

        int max = 0;

        char[] arr = s.toCharArray();

        int j = 0;

        for(int i=0; i<arr.length; i++){
            while(j < arr.length && !countingSet.contains(arr[j])){
                countingSet.add(arr[j]);
                j++;
            }
            max = Math.max(max, j-i);
            countingSet.remove(arr[i]);
        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet countingSet = new HashSet();
        Queue currentQueue = new LinkedList();

        int global_max = 0;
        int max = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(countingSet.contains(arr[i])){
                char currentPopChar = (char)currentQueue.poll();

                if(arr[i] == currentPopChar){
                    // add to queue tail, nothing else changes
                    currentQueue.add(arr[i]);
                }else{
                    //keep popping untail it's legit
                    while(arr[i] != currentPopChar){
                        countingSet.remove(currentPopChar);
                        max--;
                        currentPopChar = (char)currentQueue.poll();
                    }
                    // countingSet.remove(arr[i]); // attention: no need to do remove
                    // countingSet.add(arr[i]);    // nor remove. they cancel each other.
                    currentQueue.add(arr[i]);
                }
                System.out.println(global_max + " " + max);
                global_max = Math.max(global_max, max);
            }else{
                currentQueue.add(arr[i]);
                countingSet.add(arr[i]);
                max++;
                global_max = Math.max(global_max, max);
            }
        }

        return global_max < max? max : global_max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("bbbbbbb"));
    }
}
