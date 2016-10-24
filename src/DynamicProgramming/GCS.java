package DynamicProgramming;

/**
 * Created by lizichen1 on 10/24/16.
 *
 * Greatest Common Sequence
 * Length(i, j) =   0                                   i=0 or j=0
 *                  1 + Length(i-1, j-1)                arr1[i] = arr2[j]
 *                  Max{Length(i,j-1), Length(i-1, j)}  otherwise
 */
public class GCS {

    private static int[] arr1 = {1,2,3,4,5}; // 1 2 3 4 6 8 3 2 5 7 8
    private static int[] arr2 = {1,2,3,4,5}; // 1 2 3 4 6 8 3 2 5 7 8

    public static void main(String[] args) {
        GCS gcs = new GCS();
        int index1 = gcs.arr1.length-1;
        int index2 = gcs.arr2.length-1;
        System.out.println(greatestCommonSequence(index1, index2));
    }

    private static int greatestCommonSequence(int index1, int index2) {
        System.out.println("index1 = "+index1+" index2 = "+index2);
        if(index1 == -1 || index2 == -1){
            return 0;
        }
        else if(arr1[index1] == arr2[index2]){
            return 1 + greatestCommonSequence(index1-1, index2-1);
        }
        else{
            int max = 0;
                int length1 = greatestCommonSequence(index1-1, index2);
                int length2 = greatestCommonSequence(index1, index2-1);
                if(length1 >= length2)
                    max = length1;
                else
                    max = length2;
            System.out.println("max = "+max);
            return max;
        }
    }

    private static int greatestCommonSequence_lookup(int index1, int index2){

        return -1;
    }

    private static int greatestCommonSequence_decision(int index1, int index2){

        return -1;
    }

    /**
     * Three arrays/strings
     *  A[1..l], B[1..m], C[1..n]
     *  Length(i, j, k) =   0
     *                      1 + GCS_Trois(index_a - 1, index_b - 1, index_c - 1)
     *                      Max(GCS_Trois(index_a - 1, index_b, index_c),
     *                          GCS_Trois(index_a, index_b - 1, index_c),
     *                          GCS_Trois(index_a, index_b, index_c - 1))
     */
    private static int greatestCommonSequence_trois(int index1, int index2){

        return -1;
    }
}
