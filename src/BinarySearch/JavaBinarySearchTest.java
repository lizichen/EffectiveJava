package BinarySearch;

import java.util.Arrays;

public class JavaBinarySearchTest {
    public static void main(String[] args) {

        for(int i=0; i<50000; i++){
            int rand1 = (int)(10 * Math.random());
            int rand2 = (int)(10 * Math.random());
            int rand3 = (int)(i * 10 * Math.random());
            int rand4 = (int)(i * 10 * Math.random());

            int n1 = rand1 * rand2;
            int n2 = rand3 * rand4;
            if(n1 <= n2){
                int f1 = formula1(n1, n2);
                int f2 = formula2(n1, n2);
                if(f2 != f1){
                    System.out.println("lo = "+n1+", hi = "+n2);
                    System.out.println("formula1: "+f1+" formula2: "+f2);
                }
            }
        }
    }

    public static int formula1(int lo, int hi){
        return lo + (hi-lo)/2;
    }

    public static int formula2(int lo, int hi){
        return (lo+hi)/2;
    }
}
