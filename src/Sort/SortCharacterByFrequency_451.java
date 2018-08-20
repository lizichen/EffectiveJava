package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency_451 {

    // Bucket sort approach
    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap();
        char[] carr = s.toCharArray();
        for(Character c: carr){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List[] freqList = new List[s.length()];
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char cc  = e.getKey();
            int reps = e.getValue();
            if(freqList[reps] == null){
                freqList[reps] = new ArrayList<Character>();
            }
            freqList[reps].add(cc);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=freqList.length - 1; i>=0; i--){
            if(freqList[i] != null){
                for(int j=0; j<freqList[i].size(); j++){
                    for(int k=i; k>0; k--){
                        sb.append(freqList[i].get(j));
                    }
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(frequencySort("abadcabcbadcaba"));
    }
}
