package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring_76 {
    // Leetcode user solution:
    public static String minWindow2(String s, String t) {
        HashMap<Character,Integer> map = new HashMap();
        for(char c : s.toCharArray())
            map.put(c,0);

        for(char c : t.toCharArray())
        {
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                return "";
        }

        int start =0, end=0, minStart=0, minLen = Integer.MAX_VALUE, counter = t.length();
        while(end < s.length())
        {
            char c1 = s.charAt(end);
            if(map.get(c1) > 0)
                counter--;
            map.put(c1,map.get(c1)-1);

            end++;

            while(counter == 0)
            {
                if(minLen > end-start)
                {
                    minLen = end-start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                map.put(c2, map.get(c2)+1);

                if(map.get(c2) > 0)
                    counter++;

                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }

    public static String minWindow3(String s, String t) {

        HashMap<Character, Integer> map = new HashMap();
        for(Character c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int start = 0;
        int end   = 0;
        int count = t.length();
        int globalMin = Integer.MAX_VALUE;
        int minStartIndex = -1;

        while(end < s.length()){
            if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) > 0){
                count--;
            }
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end),0)-1);
            end++;
            // now end index points at the next one.

            while(count == 0){
                if(end - start < globalMin){
                    globalMin = end - start;
                    minStartIndex = start;
                }

                char startChar = s.charAt(start);
                if(map.containsKey(startChar)){
                    map.put(startChar, map.get(startChar)+1);
                    if(map.get(startChar) > 0) {
                        System.out.println("pop out start char:"+startChar);
                        count++;
                    }
                }
                start++;
            }
        }

        return globalMin == Integer.MAX_VALUE ? "" : s.substring(minStartIndex, minStartIndex+globalMin);
    }

    public static void main(String[] args) {
        System.out.println(minWindow2("ADOBECODEBANC", "ABC"));
    }

}
