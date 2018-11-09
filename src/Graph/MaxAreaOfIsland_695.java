package Graph;

public class MaxAreaOfIsland_695 {

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        int nr = grid.length;
        int nc = grid[0].length;

        for(int r = 0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(grid[r][c] == 1){
                    int area = dfs(grid, r, c);
                    System.out.println("area = "+area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public static int dfs(int[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if(r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        System.out.println("["+r+"]["+c+"]="+grid[r][c]);
        return 1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));

    }
}
