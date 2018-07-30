package DynamicProgramming;

/**
 * Same to House Robber
 *
 * Holey SubSum of Array A
 *  Find S that has the maximum sum of non-consecutive items in A.
 *  A = {9,3,2,8,-7,6,12,2,-1}
 *      S = 9 + 8 + 12
 *      Pac-man approach:
 *      MHS(i) =    0                                   if i <= 0
 *                  Max{ A[i] + MHS(i-2), MAS(i-1) }    otherwise
 */
public class HoleySubsum {

    private static int[] A;

    public static void main(String[] args) {
        int[] A = {9,3,2,8,-7,6,12,2,-1};
        HoleySubsum holeysum = new HoleySubsum();
        holeysum.A = A;
        System.out.println(MHS(A.length-1));
        System.out.println(MHS_iterative(A));
    }

    private static int MHS(int index) {
        if(index < 0)
            return 0;
        else{
            int len1 = A[index] + MHS(index-2); // non-consecutive!!!
            int len2 = MHS(index-1);
            if(len1 >= len2)
                return len1;
            else
                return len2;
        }
    }

    private static int MHS_iterative(int[] nums){

        // corner case!
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 0)
            return 0;

        int previous = 0;
        int current = nums[0];
        int next = 0;

        for(int i=1; i<nums.length; i++){
            next = Math.max(current, nums[i] + previous);
            previous = current;
            current = next;
        }

        return current;
    }
}
