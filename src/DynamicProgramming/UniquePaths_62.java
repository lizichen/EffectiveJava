package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths_62 {

    public static int uniquePaths(int m, int n) {

        int[] row = new int[n];
        Arrays.fill(row, 1);

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                row[j] = row[j] + row[j-1];
            }
        }

        return row[n-1];
    }

    public static void main(String[] args) {
        int row = 3;
        int col = 4;
        System.out.println("Number of unique paths = "+uniquePaths(row, col));
    }
}
