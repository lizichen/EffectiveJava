package InterviewQuiz;

import java.util.*;

/**
 * Created by lizichen1 on 8/1/18.
 *
 * Given a list of integers, represent number of seconds.
 *
 * Output a list of pairs, each adds up to multiple of 60.
 *
 * For example:
 * Input:
 *  11, 49, 109, 10, 50, 60
 * Output:
 *  [ [11, 49],
 *    [11, 109],
 *    [10, 50] ]
 */

public class GS_MusicDelima {


    public static List<List<Integer>> music_delimma(int[] arr){

        List<List<Integer>> finalResult = new LinkedList<>();

        // mod current arr, without messing up the order/indices
        int[] arr_mod = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            arr_mod[i] = arr[i] % 60;
        }

        // put into hashmap
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // value - match_index
        for(int i=0; i<arr_mod.length; i++){
            int val = arr_mod[i];
            List<Integer> match_index = new LinkedList<>();
            List<Integer> aResult = new LinkedList<>();

            if(map.containsKey(60 - val)){
                match_index = map.get(60-val);
                // add the real value to aResult
                for(Integer aIndex: match_index){
                    aResult.add(arr[i]);
                    aResult.add(arr[aIndex]);
                    finalResult.add(aResult);
                    aResult = new LinkedList<>();
                }
            }

            List<Integer> current = new LinkedList<>();
            if(map.containsKey(val)){
                current = map.get(val);
                current.add(i);
                map.put(val, current);
            }else{
                current.add(i);
                map.put(val, current);
            }
        }

        return finalResult;
    }


    // Jimmy's answer
    public static List<List<Integer>> minuteDilemma(int[] songs){
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i =0; i< songs.length; i++){
            int remain = songs[i]%60;

            // put every pair in answer
            if(map.containsKey(remain)){
                for(int index: map.get(remain)) {
                    ans.add(Arrays.asList(new Integer[]{songs[index], songs[i]}));
                }
            }

            // update hash table
            int residue = 60 - remain;
            if(!map.containsKey(residue))
                map.put(residue, new ArrayList<>());
            List<Integer> tmp = map.get(residue);
            tmp.add(i);
            map.put(residue, tmp);
        }
        return ans;
    }


    public static void main(String[] args){
//        int[] arr = {1, 11, 49, 109, 10, 50, 60};
        int[] arr = {58 ,2, 62, 118, 122, 178};
//        int[] arr = {58 ,2, 62, 118};

        printAnswer(music_delimma(arr));
        printAnswer(minuteDilemma(arr));

    }

    public static void printAnswer(List<List<Integer>> result){
        System.out.println("Pairs:");
        for(List<Integer> r : result){
            System.out.println(r);
        }
    }
}

