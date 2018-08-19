package InterviewQuiz;

import java.util.HashSet;

public class Uber_SudokuValidator_36 {

    public boolean isValidSudoku(int[][] grid){
        for(int i=0;i<9;i++){
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> column = new HashSet<>();
            HashSet<Integer> cubeSet = new HashSet<>();

            for(int j=0;j<9;j++){
                if(!rows.add(grid[i][j])){
                    return false;
                }
                if(!column.add(grid[j][i])){
                    return false;
                }
                // by having j from 0 to 8,
                // produce (0, ***), (1, ***), and (2, ***) for a current cube.
                int cubRowIndex = 3*(i/3) + j/3;
                int cubColIndex = 3*(i%3) + j%3;
                if(!cubeSet.add(grid[cubRowIndex][cubColIndex])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
