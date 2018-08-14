package MathRelated;

public class UglyNumber_263 {

    public static boolean isUgly(int num) {
        if(num == 1) return true;

        while(true){
            num = modIsZero(num);
            if(num == -1){
                return false;
            }else if(num == 1){
                return true;
            }
        }
    }

    public static int modIsZero(int num){
        if(num % 2 == 0){
            return num/2;
        }else if(num % 3 == 0){
            return num/3;
        }else if(num % 5 == 0){
            return num/5;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
}
