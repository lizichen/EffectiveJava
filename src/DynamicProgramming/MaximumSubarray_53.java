package DynamicProgramming;

import util.Printer;

public class MaximumSubarray_53 {
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0];
        int maxEndingHere=A[0];

        int[] maxEndingHereArr = new int[A.length];
        int[] maxSoFarArr      = new int[A.length];
        maxEndingHereArr[0] = maxEndingHere;
        maxSoFarArr[0] = maxSoFar;


        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i], A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
            maxEndingHereArr[i] = maxEndingHere;
            maxSoFarArr[i]      = maxSoFar;
        }

        Printer.printIntArray(A);
        Printer.printIntArray(maxEndingHereArr);
        Printer.printIntArray(maxSoFarArr);

        return maxSoFar;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
