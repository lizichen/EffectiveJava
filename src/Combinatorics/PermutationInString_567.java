package Combinatorics;

import java.util.HashMap;
import java.util.HashSet;

public class PermutationInString_567 {

    public static boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
            return false;

        int[] s1arr = new int[26];
        int[] s2arr = new int[26];
        HashSet s1set = new HashSet();

        for(int i=0; i<s1.length(); i++){
            s1arr[s1.charAt(i) - 'a']++;
            s1set.add(s1.charAt(i));
            s2arr[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<s2.length() - s1.length(); i++){
            if(s1set.contains(s2.charAt(i)) && match(s1arr, s2arr)){
                return true;
            }else{
                s2arr[s2.charAt(i) - 'a']--;
                s2arr[s2.charAt(i+s1.length()) - 'a']++;
            }
        }

        return match(s1arr, s2arr);
    }

    public static boolean match(int[] s1arr, int[] s2arr){
        for(int i=0; i<s1arr.length; i++){
            if(s1arr[i] != s2arr[i])
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "adba";
        System.out.println(checkInclusion(s1, s2));
    }
}
