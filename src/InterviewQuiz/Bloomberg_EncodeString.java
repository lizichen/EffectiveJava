package InterviewQuiz;

public class Bloomberg_EncodeString {

    public static String encode(String input){
        // base case:
        if(input == null || input.length()<=2){
            return input;
        }

        StringBuilder sb = new StringBuilder("");
        char[] arr = input.toCharArray();

        int i = 0;
        char baseLetter = arr[i];

        for(int j=1; j<arr.length; j++){
            if(baseLetter == arr[j]){
                continue;
            }else{
                sb = add(sb, baseLetter, j - i);
                i = j;
                baseLetter = arr[i];
            }
        }
        return sb.toString();
    }

    public static StringBuilder add(StringBuilder sb, char baseLetter, int reps){
        if(reps == 1){
            sb.append(baseLetter);
        }else if(reps == 2){
            sb.append(baseLetter);
            sb.append(baseLetter);
        }else{
            sb.append(baseLetter);
            sb.append('#');
            sb.append(reps);
        }
        return sb;
    }


    public static void main(String[] args) {
        String test = "ddddjjwwwwwrjjjkk";
        System.out.println(encode(test));
    }
}
