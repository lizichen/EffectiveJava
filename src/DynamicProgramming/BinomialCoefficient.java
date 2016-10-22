package DynamicProgramming;

/**
 * Created by lizichen1 on 10/20/16.
 * C(n, k) = C(n-1, k-1) + C(n-1, k)
 * C(n, 0) = C(n, n) = 1
 */
public class BinomialCoefficient {

    public static int[][] lookup;

    public static int binomialCoeff_1(int n, int k){
        //System.out.println("binomialCoeff_1("+n+","+k+")");
        if(k == 0 || k == n) {
            return 1;
        }
        else {
            return binomialCoeff_1(n - 1, k - 1) + binomialCoeff_1(n - 1, k);
        }
    }

    public static int binomialCoeff_2(int n, int k){
        int value = lookup[n][k];
        if(value != -1){
            System.out.println("Looking for lookup["+n+"]["+k+"]");
            return lookup[n][k];
        }
        else if(k == 0 || k == n){
            return 1;
        }else{
            lookup[n-1][k-1] = binomialCoeff_2(n - 1, k - 1);
            lookup[n-1][k] = binomialCoeff_2(n - 1, k);
            return lookup[n-1][k-1] + lookup[n-1][k];
        }
    }

    public static int pascalTriangleApproach(int n, int k){
        int[] C = new int[k+1];
        C[0] = 1;
        for( int i = 1; i< n+1;i++){
            int j = Math.min(i, k);
            while(j > 0){
                C[j] = C[j] + C[j-1];
                j -= 1;
            }
        }
        for(int i=0;i<k+1;i++)
            System.out.print(C[i]+" ");
        System.out.println();
        return C[k];
    }

    public static void main(String[] args) {
        // Basic Recursion
        System.out.println(binomialCoeff_1(6,3));
        // Basic Dynamic Programming with a non-optimized lookup table.
        BinomialCoefficient.lookup = new int[7][4];
        for(int i=0;i<7;i++)
            for(int j=0;j<4;j++)
                lookup[i][j] = -1; // initialize the lookup table
        System.out.println(binomialCoeff_2(6,3));
        for(int i=0;i<7;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(lookup[i][j] + "\t");
            }
            System.out.println();
        }
        // O(n) time dynamic programming with an optimized lookup array
        System.out.println(pascalTriangleApproach(6,3));
    }
}
