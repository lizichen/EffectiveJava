package Graph;

/**
 * Created by lizichen1 on 3/19/17
 *
 * https://leetcode.com/problems/island-perimeter/#/description
 */
public class IslandPerimeter_463 {

    // notice the fact that:
    // #Perimeter = #Island - #Neighbor
    public static int islandPerimeter(int[][] grid) {
        if(grid == null && grid.length == 0)
            return 0;

        int neighbors = 0;
        int islands   = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    islands++;
                    if(r+1 < grid.length && grid[r+1][c] == 1)
                        neighbors++;
                    if(c+1 < grid[0].length && grid[r][c+1] == 1)
                        neighbors++;
                }
            }
        }

        return islands*4 - neighbors*2;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid2 = {{1}};
        System.out.println(islandPerimeter(grid2));
    }

}


