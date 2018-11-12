package DynamicProgramming;

public class DecodeWays_91 {
    public static int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;

        int[] memo = new int[s.length()];
        return helper(s, s.length() - 1, memo);
    }

    public static int helper(String s, int idx, int[] memo){
        // has to go backwards
        if(idx <= 0){
            return 1;
        }

        // if(s.charAt(idx) == '0'){
        //     return 0;
        // }

        if(memo[idx] != 0)
            return memo[idx];

        int result = 0;
        if(s.charAt(idx) - '0' > 0){
            result += helper(s, idx-1, memo);
        }

        if(s.charAt(idx-1) != '0' && Integer.valueOf(s.substring(idx-1, idx+1)) <= 26){
            result += helper(s, idx-2, memo);
        }

        memo[idx] = result;
        System.out.println("idx = "+idx+" result = "+result);
        return result;
    }

    public static int numDecodings2(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] memo = new int[n+1];
        memo[n] = 1;

        int zeroCounter = 0;
        if(s.charAt(n-1) == '0'){
            zeroCounter = 1;
            memo[n-1] = 0;
        }else{
            memo[n-1] = 1;
        }

        for(int i=n-2; i>=0; i--){
            if(s.charAt(i) == '0'){
                zeroCounter++;
                if(zeroCounter >= 2)
                    return -1;
            }else{
                if(Integer.parseInt(s.substring(i, i+2)) <= 26){
                    memo[i] = memo[i+1] + memo[i+2];
                }else{
                    memo[i] = memo[i+1];
                }
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings2("120321"));
    }
}
