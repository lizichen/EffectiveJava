package InterviewQuiz;

/**
 * Created by lizichen1 on 3/19/17
 *
 * https://leetcode.com/problems/island-perimeter/#/description
 */
public class IslandPerimeter_463 {

    // NOT A GOOD Answer!
    // O(n^m)
    public static int islandPerimeter(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        // rows:
        int rowSum = 0;
        for(int i=0; i<numberOfRows;i++){
            int flips = 0;
            int origin = grid[i][0];
            if(origin == 1)
                flips = 1;
            for(int j=0; j<numberOfColumns;j++){
                if(grid[i][j] != origin){
                    flips++;
                    origin = grid[i][j];
                }
            }
            if (flips % 2 == 1)
                rowSum = rowSum + flips + 1;
            else
                rowSum += flips;
        }
        System.out.println("row sum: "+rowSum);
        // columns:
        int columnSum = 0;
        for(int i=0; i<numberOfColumns; i++){
            int flips = 0;
            int origin = grid[0][i];
            if(origin == 1)
                flips = 1;
            for(int j=0; j<numberOfRows;j++){
                if(grid[j][i] != origin){
                    flips++;
                    origin = grid[j][i];
                }
            }
            if (flips % 2 == 1)
                columnSum = columnSum + flips + 1;
            else
                columnSum += flips;
        }
        System.out.println("column sum: "+columnSum);

        return (rowSum + columnSum);
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid2 = {{1}};
        System.out.println(islandPerimeter(grid2));
    }

}


