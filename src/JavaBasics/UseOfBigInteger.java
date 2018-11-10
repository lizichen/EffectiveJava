package JavaBasics;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * Java BigInteger is immutable!
 */
public class UseOfBigInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        BigInteger sum = BigInteger.valueOf(0);
        for(int i=0;i<n;i++){
            sum = sum.add(BigInteger.valueOf(arr[i])); // have to assign the incremented sum to itself for a new value!!!
        }

        System.out.println(sum.toString());
    }

}
