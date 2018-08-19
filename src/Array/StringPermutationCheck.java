package Array;
// Crack coding interview 1.3

public class StringPermutationCheck {

    public static boolean isPermutation(String a, String b){

        if(a.length() != b.length())
            return false;

        int[] letters = new int[256];
        
        char[] a_arr = a.toCharArray();
        for (char aChar : a_arr) {
            letters[aChar]++;
        }

        int bIdx = 0;
        while(bIdx < b.length()){
            char bChar = b.charAt(bIdx++);
            letters[bChar]--;
            if(letters[bChar] < 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("dog", "god"));
    }
}
