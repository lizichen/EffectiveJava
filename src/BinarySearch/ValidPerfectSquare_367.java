package BinarySearch;

public class ValidPerfectSquare_367 {

    public static boolean isPerfectSquare(int num) {

        if(num == 0){
            return false;
        }else if(num == 1){
            return true;
        }

        int left = 0;
        int right = num;
        int mid = 0;

        while(true){
            mid = left + (right - left)/2;
            if(mid*mid == num){
                return true;
            }else if(mid <= num/mid && (mid+1) > num/(mid+1)){ // Review: mid <= num/mid
                return false;
            }else if(mid > num/mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
    }

    public static void main(String[] args) {

        /*
        for(int i=2147483644; i<=2147483647; i++){
            int correct = (int)Math.sqrt(i);
            if(correct*correct == i){
                // should be true
                if(isPerfectSquare(i)){
                    System.out.println(i+" true");
                }else{
                    System.out.println(i+" is wrong");
                }
            }else{
                // should be false
                if(isPerfectSquare(i)){
                    System.out.println(i+" is wrong");
                }else{
                    System.out.println(i+" false");
                }
            }
        }
        */

        isPerfectSquare(5);

    }
}
