package InterviewQuiz;

import util.Printer;

/**
 * Created by lizichen1 on 10/22/16.
 */
public class PascalTriangle {

    private  int[] previousRow;
    private  int[] currentRow;
    private static int level;

    public PascalTriangle(int level){
        this.level = level;
        this.previousRow = new int[level];
        this.currentRow = new int[level];
    }

    public static void main(String[] args) {
        int n = 10;
        PascalTriangle pascalTri = new PascalTriangle(n);
        pascalTri.printPascalTriagnleDriver();
    }

    private void printPascalTriagnleDriver() {
        this.printPascalTriagnle(this.level);
        this.printPascal(this.level);
    }

    private void printPascalTriagnle(int level) {
        int[] previousRow = new int[level];
        for(int i=0;i<level;i++){
            int[] currentRow = new int[i+1];
            currentRow[0] = 1;
            if(i != 0){
                for(int j=1;j<currentRow.length;j++){
                    if( j == currentRow.length-1)
                        currentRow[j] = 1;
                    else
                        currentRow[j] = previousRow[j] + previousRow[j-1];
                }
            }
            System.out.println(Printer.printIntArray(currentRow));
            previousRow = currentRow;
        }
    }

    private void printPascal(int n)
    {
        for (int line = 1; line <= n; line++)
        {
            int C = 1;
            for (int i = 1; i <= line; i++)
            {
                System.out.print(C+" ");
                C = C * (line - i) / i;
            }
            System.out.println();
        }
    }


}
