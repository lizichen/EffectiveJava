package InterviewQuiz;

public class Zillow_Missing4 {

    // given an array of numbers, from 1 to N, there are 4 numbers missing in this array. Find them.
    public static void missing4(int[] arr){
        int[] helper = new int[4];

        for(int i=0; i<arr.length; i++){
            int tmp = Math.abs(arr[i]);

            if(tmp <= arr.length)
                arr[tmp - 1] *= -1;
            else{
                if(tmp % arr.length != 0)
                    helper[tmp % arr.length - 1] = -1;
                else
                    helper[tmp % arr.length + arr.length - 1] = -1;
            }
        }

        for(int i=0; i<arr.length; i++)
            if(arr[i] > 0)
                System.out.println(i+1+" ");
        for(int i=0; i<helper.length; i++)
            if(helper[i] >= 0)
                System.out.println(arr.length + i + 1 + " ");
    }


    public static void missingN(int[] arr, int missings){
        int[] helper = new int[missings];
        int arrLen = arr.length;

        for(int i=0; i<arr.length; i++){
            int currentVal = Math.abs(arr[i]);

            if(currentVal <= arrLen){
                arr[currentVal-1] = -arr[currentVal-1];
            }else{
                helper[currentVal - arrLen - 1] = -1;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                System.out.println(i+1);
            }
        }
        for(int i=0; i<helper.length; i++){
            if(helper[i] == 0){
                System.out.println(i+arrLen+1);
            }
        }
    }

    public static void main(String[] args) {
        missing4(new int[]{2,5,6,3,9});

        int[] arr = new int[]{1,2,3,4,10,12,14,16,18,20};
        int missings = 10;
        missingN(arr, missings);
    }
}
