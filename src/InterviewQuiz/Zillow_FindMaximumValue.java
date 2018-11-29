package InterviewQuiz;

// Nov 27, 2018
// Phone InteriveW:
//
// Given a list of Strings
// ["aabc", "bccd", "cddd", "aaaa"]
// only five characters are in this list: a, b, c, d, e
// each is assigned with a value in {1,2,3,4,5}
// assume the 1-1 mapping is:
//   a-1
//   b-2
//   c-3
//   d-4
//   e-5
// the original list of String can be converted to:
// [1123, 2334, 3444, 1111]
//
// Now we need to find the mapping tha maximize the sum of this list integers
//
import java.util.*;

public class Zillow_FindMaximumValue {
    public static int getMax(List<String> input){
        HashMap<Character, Integer> map = new HashMap<>();
        for(String s : input)
            analyzeThisString(s, map);

        List<Integer> valuesList = new ArrayList<>(map.values());
        Collections.sort(valuesList, (a, b) -> b - a);

        int result = 0;
        int multiplier = 5;
        for(Integer e : valuesList){
            result += e * multiplier--;
        }

        return  result;
    }

    public static void analyzeThisString(String s, HashMap<Character, Integer> map){
        char[] arr = s.toCharArray();
        int len = arr.length;
        for(int i=0; i<len; i++){
            int addVal = (int)Math.pow(10, len-i-1);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+addVal);
        }
    }

    // test case:
    public static void main(String[] args) {
        List<String> input = new LinkedList<>();
            input.add("eabcd");
            input.add("eabc");
            input.add("eab");
            input.add("ea");
            input.add("e");

        System.out.println(getMax(input));
    }
}

// follow up:
// 1: overflow:


// 2: a-b values change to 0-4 instead of 1-5:

