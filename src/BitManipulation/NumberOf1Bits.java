package BitManipulation;

/**
 * Created by lizichen1 on 10/24/16.
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        long unsignedInt = 11;
        System.out.println(numberOf1Bits(unsignedInt));

    }

    private static int numberOf1Bits(long unsignedInt) {
        int count = 0;
        while(unsignedInt > 0){
            long andResult = unsignedInt & 1;
            if(andResult == 1)
                count++;
            unsignedInt >>= 1;
        }
        return count;
    }

}
