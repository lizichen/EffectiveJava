package InterviewQuiz;

import javax.xml.crypto.Data;
import java.util.*;

// Float_Ceil_or_Floor:
// 思路就是先把所有floor加起来，然后看差多少，然后把多少个floor转成ceil
// 转的时候按照num本身与ceil的距离排序
public class Airbnb_OA12 {

    // online others
    public static int[] Solution1(double[] arr) {
        NumWithDiff[] arrWithDiff = new NumWithDiff[arr.length];
        double sum = 0.0;
        int floorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int floor = (int)arr[i];
            int ceil = floor;
            if (floor < arr[i]) // 查是不是4.0这种floor/ceil都是本身的
                ceil++;
            floorSum += floor;
            sum += arr[i];
            arrWithDiff[i] = new NumWithDiff(ceil, ceil - arr[i]); // 把ceil都放在数组里面进行比较
        }

        int num = (int) Math.round(sum);
        int diff = num - floorSum;

        Arrays.sort(arrWithDiff, (a, b) -> a.diffWithCeil <= b.diffWithCeil ? -1 : 1);

//        System.out.println("After sort: arrWithDiff:");
//        for(NumWithDiff nn : arrWithDiff)
//            System.out.println(nn.num+" "+nn.diffWithCeil);
//        System.out.println("diff = "+diff);
        int[] res = new int[arr.length];
        int i = 0;
        for (; i < diff; i++) {
            res[i] = arrWithDiff[i].num; // 这些放ceil
        }
        for (; i < arr.length; i++) {
            res[i] = arrWithDiff[i].num - 1; // 剩下的只放floor
        }
        return res;
    }

    // online others
    public static int[] Solution2(double[] inputs) {
        double sum = 0;
        int sRound = 0; // separately rounded
        List<Double> ls = new ArrayList();
        for ( double d : inputs ) {
            sum += d;
            sRound += (int)Math.round( d );
            ls.add(d);
        }
        int tRound = (int) Math.round( sum ); // together rounded
        int diff = tRound - sRound;

        boolean over = true;
        if ( diff >= 0 ) {
            Collections.sort( ls , new CPP() );
        } else {
            Collections.sort( ls , new CPN() );
            over = false;
        }

        diff = (int)Math.abs( diff );
        Set< Double > set = new HashSet< Double >();
        for ( int i = 0; i < diff; ++i ) {
            set.add( ls.get(i) );
        }

        int[] res = new int[ inputs.length ];
        for ( int i = 0; i < res.length; ++i  ) {
            double d = inputs[i];
            int tmp = (int)Math.round( d );
            if ( set.contains(d) && diff > 0 ) {
                if ( over ) {
                    ++tmp;
                } else {
                    --tmp;
                }
                --diff;
            }
            res[i] = tmp;
        }
        return res;
    }

    // Lizi
    public static int[] Solution3(double[] arr){
        TreeMap<Double, List<Integer>> map = new TreeMap<>(); // difference, the floor
        double realSum = 0.0;
        int floorSum = 0;
        double xFloor;
        for(double x : arr){
            xFloor = Math.floor(x);
            realSum += x;
            floorSum += xFloor;
            if(!map.containsKey(x - xFloor))
                map.put(x-xFloor, new ArrayList<Integer>());
            map.get(x - xFloor).add((int)(x)); // can just be (int)x
        }

        int diff = (int)(Math.round(realSum) - floorSum); // we need to add diff number of 1s
        int[] result = new int[arr.length];
        int idx = 0;
        for(List<Integer> floorVals : map.descendingMap().values()){
            for(Integer floorVal : floorVals){
                if(idx < diff){ // only add [diff] number of 1.
                    result[idx] = floorVal+1;
                }else{
                    result[idx] = floorVal;
                }
                idx++;
            }
        }
        return result;
    }

    // Lizi, with Target param
    public static int[] Solution4(double[] arr, int target){

        // Phase 1: digest the data into TreeMap data structure:
        TreeMap<Double, List<Integer>> map = new TreeMap<>(); // TreeMap<difference, the floor>
        int floorSum = 0;
        double xFloor;
        for(double x : arr){
            xFloor = Math.floor(x);
            floorSum += xFloor;
            if(!map.containsKey(x - xFloor))
                map.put(x-xFloor, new ArrayList<Integer>());
            map.get(x - xFloor).add((int)(x)); // can just be (int)x
        }

        // Phase 2: Iterate the TreeMap, construct result:
        int diff = target - floorSum; // we need to add diff number of 1s
        int[] result = new int[arr.length];
        int idx = 0;
        for(List<Integer> floorVals : map.descendingMap().values()){
            for(Integer floorVal : floorVals){
                result[idx] = idx < diff ? (floorVal + 1) : floorVal; // only add [diff] number of 1.
                idx++;
            }
        }

        return result;
    }

    // Lizi, in order
    public static int[] Solution5(double[] arr, int target){

        DataEntry[] entries = new DataEntry[arr.length];
        int floorSum = 0;
        for(int i=0; i<arr.length; i++){
            double x = arr[i];
            int    xFloor = (int)x;
            floorSum += xFloor;
            DataEntry newDataEntry = new DataEntry(i, xFloor, x - xFloor);
            entries[i] = newDataEntry;
        }

        int diff = target - floorSum;
        // sort entries according to difference
        Arrays.sort(entries, (a, b) -> a.diff >= b.diff ? -1 : 1);

        // add 1 to the first diff entries
        int idx = 0;
        while(idx < diff){
            entries[idx] = new DataEntry(entries[idx].index, entries[idx].floorVal+1, entries[idx].diff);
            idx++;
        }

        // sort entries according to original idx
        Arrays.sort(entries, (a, b) -> a.index < b.index ? -1 : 1);

        // add back to result
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = entries[i].floorVal;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] res;

        //testcases:
//        double[] arr = {1.2, 1.9, 1.8}; // fine
//        double[] arr = {1.2, 1.3, 1.1}; // fine
//        double[] arr = {1.2, 1.2, 1.2}; // fine
//        double[] arr = {1.6, 1.6, 1.6}; // fine
//        double[] arr = {1.0, 2.0, 2.0, 3.0};

//        double[] arr = {1.2, 2.5, 3.6, 4.0}; // fine expect: [1,2,4,4]
//        int target = 11;
//        double[] arr = {0.7, 2.8, 4.9}; // fine expect: [0,3,5]
//        int target = 8;
        double[] arr = { 1.2, 3.7, 2.3, 4.8, 5.0, 6.7}; // fine
        int target = 24;

//        System.out.println("Solution1:");
//        int[] res = Solution1(arr);
//        for (int i : res)
//            System.out.print(i + " ");
//
//        System.out.println("\nSolution2:");
//        res = Solution2(arr);
//        for (int i : res)
//            System.out.print(i + " ");
//
//        System.out.println("\nSolution3:");
//        res = Solution3(arr);
//        for (int i : res)
//            System.out.print(i + " ");

        System.out.println("\nSolution4:");
        res = Solution4(arr, target);
        for(int i : res)
            System.out.print(i + " ");

        System.out.println("\nSolution5:");
        res = Solution5(arr, target);
        for(int i: res)
            System.out.print(i + " ");
    }
}

class DataEntry{
    int index;
    int floorVal;
    double diff;
    public DataEntry(int index, int floorVal, double differenceFromFloor){
        this.index = index;
        this.floorVal = floorVal;
        this.diff = differenceFromFloor;
    }
}

class NumWithDiff {
    int num;
    double diffWithCeil;
    public NumWithDiff(int n, double c) {
        this.num = n;
        this.diffWithCeil = c;
    }
}

class CPP implements Comparator< Double > {
    public int compare( Double d1 , Double d2 ) {
        d1 = d1 - Math.floor(d1) ;
        d2 = d2 - Math.floor(d2) ;
        if ( d2 > d1 ) {
            return 1;
        } else {
            return -1;
        }
    }
}

class CPN implements Comparator< Double > {
    public int compare( Double d1 , Double d2 ) {
        d1 = d1 - Math.floor(d1) ;
        d2 = d2 - Math.floor(d2) ;
        if ( d1 > d2 ) {
            return 1;
        } else {
            return -1;
        }
    }
}