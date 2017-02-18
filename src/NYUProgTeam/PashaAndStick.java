package NYUProgTeam;

/**
 *
 * Feb 17, 2017. NYU ProgTeam
 *
 Pasha has a wooden stick of some positive integer length n. He wants to perform exactly three cuts to get four parts of the stick. Each part must have some positive integer length and the sum of these lengths will obviously be n.

 Pasha likes rectangles but hates squares, so he wonders, how many ways are there to split a stick into four parts so that it's possible to form a rectangle using these parts, but is impossible to form a square.

 Your task is to help Pasha and count the number of such ways. Two ways to cut the stick are considered distinct if there exists some integer x, such that the number of parts of length x in the first way differ from the number of parts of length x in the second way.

 Input
 The first line of the input contains a positive integer n (1 ≤ n ≤ 2·109) — the length of Pasha's stick.

 Output
 The output should contain a single integer — the number of ways to split Pasha's stick into four parts of positive integer length so that it's possible to make a rectangle by connecting the ends of these parts, but is impossible to form a square.
 */

import java.util.Scanner;

public class PashaAndStick {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(divide(n));
    }

    public static int divide(int n){
        int numOfDiv = 0;
        int reminder = 0;
        if(n % 2 != 1){
            n = n/2;
            int edge = n/2; //  11/2 = 5   10/2 = 5
            reminder = n%2 == 1?1:0;
            int min = 1;
            while(true){
                if(min <= edge){
                    numOfDiv++;
                }else{
                    break;
                }
                min++;
            }
        }else{
            return 0;
        }
        return reminder == 1 ? numOfDiv : numOfDiv-1;
    }
}
