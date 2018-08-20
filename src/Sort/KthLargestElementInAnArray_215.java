package Sort;

import util.Printer;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray_215 {

    // Appraoch 1: using priority queue
    public static int findKthLargest1(int[] nums, int k) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // Review: Approach 2: using partition
    public static int findKthLargest2(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
            Printer.printIntArray(nums);
        }
        return nums[k];
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && a[++i] < a[lo]);
            while(j > lo && a[lo] < a[--j]);
            if(i >= j) {
                break;
            }
            System.out.println("exchange i="+i+" j="+j);
            exch(a, i, j);
        }
        System.out.println("exchange lo="+lo+" j="+j);
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest2(arr, k));
    }
}