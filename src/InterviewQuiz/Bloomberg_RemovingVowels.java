package InterviewQuiz;

public class Bloomberg_RemovingVowels {

    public static void removeVowels(char[] arr){
        System.out.println("Before removing: "+String.valueOf(arr));
        if(arr == null || arr.length == 0)
            return ;

        int A = 0;
        int B = 0;
        while(A < arr.length){
            if(isVowels(arr[A])){
                A++;
            }else{
                arr[B++] = arr[A++];
            }
        }
        while(B < arr.length){
            arr[B++] = ' ';
        }
        System.out.println("After removing: "+String.valueOf(arr));
    }

    public static boolean isVowels(char c){
        // a e i o u
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String s = "we eat something";
        removeVowels(s.toCharArray());
    }
}

