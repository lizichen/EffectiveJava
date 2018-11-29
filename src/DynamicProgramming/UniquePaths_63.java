package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0] == 1)
            return 0;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[] dp = new int[col];

        // init
        for(int i=0; i<col; i++){
            if(obstacleGrid[0][i] == 0) // not obstacle
                dp[i] = 1;
            else{
                while(i < col){
                    dp[i] = 0;
                    i++;
                }
                break;
            }
        }
        System.out.println(Arrays.toString(dp));

        // start from the second row
        for(int i=1; i<row; i++){
            if(obstacleGrid[i][0] == 1)
                dp[0] = 0;
            for(int j=1; j<col; j++){
                int gridVal = obstacleGrid[i][j];
                if(gridVal == 1){
                    dp[j] = 0;
                }else{
                    dp[j] = dp[j-1] + dp[j];
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[col-1];
    }

    public static void main(String[] args) {

    }
}
