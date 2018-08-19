package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null)
            return null;

        List<Integer> result = new ArrayList();

        if(matrix.length == 0)
            return result;
        if(matrix[0].length == 0)
            return result;

        int matrixSize = matrix.length * matrix[0].length;

        int x = 0;
        int y = 0;

        int up    = 0;
        int right = matrix[0].length - 1;
        int low   = matrix.length - 1;
        int left  = 0;

        while(result.size() != matrixSize){
            while(left <= x && x <= right){  // left -> right
                result.add(matrix[y][x]);
                if(x == right)
                    break;
                x++;
            }
            if(result.size() == matrixSize) break;
            up++;
            y++;

            while(up <= y && y <= low){      // up -> low
                result.add(matrix[y][x]);
                if(y == low)
                    break;
                y++;
            }
            if(result.size() == matrixSize) break;
            right--;
            x--;

            while(left <= x && x <= right){  // right -> left
                result.add(matrix[y][x]);
                if(left == x)
                    break;
                x--;
            }
            if(result.size() == matrixSize) break;
            low--;
            y--;

            while(up <= y && y <= low){      // low -> up
                result.add(matrix[y][x]);
                if(up == y)
                    break;
                y--;
            }
            left++;
            x++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };

        spiralOrder(m);
    }

}
