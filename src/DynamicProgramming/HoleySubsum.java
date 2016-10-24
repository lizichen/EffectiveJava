package DynamicProgramming;

/**
 * Created by lizichen1 on 10/24/16.
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
}
