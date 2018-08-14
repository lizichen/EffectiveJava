package MathRelated;

public class NthUglyNumber_264 {

    public static int nthUglyNumber(int n) {

        if(n == 1){
            return 1;
        }

        int base2 = 2;
        int base3 = 3;
        int base5 = 5;

        int[] idxVal = new int[n+1];
        idxVal[0] = 1;
        idxVal[1] = 1;

        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;

        int num2, num3, num5, currentMin = 1;


        for(int i=2; i<=n; i++){
            num2 = base2*idxVal[idx2];
            num3 = base3*idxVal[idx3];
            num5 = base5*idxVal[idx5];
            currentMin = Math.min(Math.min(num2, num3), num5);
            idxVal[i] = currentMin; // very tricky!

            if(currentMin == num2){
                idx2++;
            }

            if(currentMin == num3){
                idx3++;
            }

            if(currentMin == num5){
                idx5++;
            }
        }

        return currentMin;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }
}
