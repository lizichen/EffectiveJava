package InterviewQuiz;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Given a list of integers:
 *  [45, 51, 9, 52, 3, 700]
 *
 * Sort them:
 *  [9, 700, 52, 51, 45, 3]
 *
 * Explain:
 *  9 > 7 > 5 = 5 > 4 > 3
 *      0   2 > 1   5
 *      0
 */
public class KPMG_SortIntegers {
    public static void sort1(int[] arr){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxDigit = getMaxDigit(arr);
        for(int x : arr){
            //key: x in maxDigit
            //val: x
            map.put(convert(x, maxDigit), x);
        }
        int[] result = new int[arr.length];
        int i=0;
        for(Integer v : map.descendingMap().values()){
            result[i++] = v;
            System.out.println(v);
        }
    }

    private static int convert(int x, int maxDigit) {
        while(x < (int)Math.pow(10, maxDigit-1)){
            x = x*10;
        }
        return x;
    }

    private static int getMaxDigit(int[] arr) {
        int maxDigit = 1;
        for(int x : arr){
            int count = 1;
            while(x > 10){
                x  = x/10;
                count++;
            }
            maxDigit = Math.max(maxDigit, count);
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        int[] arr = {45, 51, 9, 52, 3, 700};
        sort1(arr);
    }
}
