package Hashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DegreeOfAnArray_697 {

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, MapValue> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            if(!map.containsKey(n)){
                map.put(n, new MapValue(i));
            }else{
                MapValue newVal = map.get(n);
                newVal.lastIdx = i;
                newVal.reps++;
                map.put(n, newVal);
            }
        }

        Comparator<Map.Entry<Integer, MapValue>> comp = (a, b) -> {
            return b.getValue().reps - a.getValue().reps;
        };

        PriorityQueue<Map.Entry<Integer, MapValue>> pq = new PriorityQueue(comp);
        for(Map.Entry<Integer, MapValue> e: map.entrySet()){
            pq.add(e);
        }

        int distance = nums.length + 1;
        int maxReps = pq.peek().getValue().reps;

        while(pq.size() != 0){
            if(pq.peek().getValue().reps < maxReps){
                break;
            }else{
                Map.Entry<Integer, MapValue> e = pq.poll();
                MapValue v = e.getValue();
                if(v.lastIdx - v.firstIdx + 1 < distance){
                    distance = v.lastIdx - v.firstIdx + 1;
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1}));
        // Result:
        //      Arr = new int[]{1,2,2,3,1})
        // Expect:
        //      2
        // Explain:
        //      There are two 1's (also, there are two 2's) , so the degree of this array; as the max reps of an unique number; in this case, either 1 or 2.
        //      The degree is 2
        //      To find the shortest continuous subarray that also has a degree of 2.
        //      We can choose 1,2,2,3,1, where number 1 is the designated number to represent its reps for the degree
        //      Or, we can choose 2,2, where 2 is also the degree of it.
        //      Apparently, the subarray {2, 2} is shorter, and it's length is 2.
    }
}

class MapValue{
    int reps;
    int firstIdx;
    int lastIdx;

    public MapValue(int firstIdx){
        this.reps = 1;
        this.firstIdx = firstIdx;
        this.lastIdx = firstIdx;
    }
}
