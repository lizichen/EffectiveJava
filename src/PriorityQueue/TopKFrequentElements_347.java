package PriorityQueue;

import util.Printer;

import java.util.*;

public class TopKFrequentElements_347 {

    // Use PriorityQueue
    public List<Integer> topKFrequent2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap();
        for(Integer n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Review:
        // return positive: a < b
        // return negative: a > b
        Comparator<Map.Entry<Integer, Integer>> comp = (a, b) -> {
            return b.getValue() - a.getValue();
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue(comp);
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pq.add(e);
        }

        System.out.println(pq.peek());

        List<Integer> result = new ArrayList();
        while(k>0){
            result.add(pq.poll().getKey());
            k--;
        }

        return result;
    }

    public static List<Integer> topKFrequent1(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void topKSmallFrequent(int[] nums, int k){
        Arrays.sort(nums);

        List<Integer> res = new ArrayList();
        int prev = nums[0];
        res.add(prev);
        k--;

        for(int i = 1; i<nums.length; i++){
            if(prev != nums[i]){
                k--;
                prev = nums[i];
                res.add(prev);
            }
            if(k == 0)
                break;
        }
        Printer.printList(res);
    }

    public static void main(String[] args) {
//        topKFrequent1(new int[]{1,2,3,3,3,3,3,3,3,4}, 2);
        topKSmallFrequent(new int[]{1,2,3,3,3,3,3,3,3,4}, 3);
    }
}
