package DynamicProgramming;

/**
 * Created by lizichen1 on 7/29/18.
 */
public class MaxLengthRepeatedSubarray_718 {

    public int findLength(int[] A, int[] B) {

        int[][] matrix = new int[A.length][B.length];

        //         B
        //       3 2 1 2
        // A  3
        //    2
        //    1


        // initialize the matrix
        for(int i=0; i<A.length; i++){
            if(A[0] == B[i]){
                matrix[0][i] = 1;
            }else{
                matrix[0][i] = 0;
            }
        }

        for(int i=0; i<B.length; i++){
            if(B[0] == A[i]){
                matrix[i][0] = 1;
            }else{
                matrix[i][0] = 0;
            }
        }

        int currentMax = 0;
        for(int i=0; i<A.length; i++){
            int Aval = A[i];
            for(int j=0; j<B.length; j++){
                if(i>=1 && j>=1){
                    int Bval = B[j];
                    int diagonalVal = matrix[i-1][j-1];
                    matrix[i][j] = (Aval == Bval) ? (diagonalVal + 1) : 0;
                    currentMax = Math.max(currentMax, matrix[i][j]);
                }
            }
        }

        return currentMax;
    }

}
