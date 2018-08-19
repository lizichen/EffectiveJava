package Array;

//Crack Coding Interview 1.5

// input: aabccccaaa
// output: a2b1c5a3

import java.util.Arrays;

public class StringCompression {

    // Use of StringBuffer
    // Not using hashtable
    public static String stringcomp_1(String input){

        StringBuffer output = new StringBuffer();

        int baseIdx = 0;
        int countIdx = 0;
        int currentCount = 0;


        while(baseIdx < input.length()){
            char baseChar = input.charAt(baseIdx);
            while(baseChar == input.charAt(countIdx)){
                currentCount++;
                countIdx++;
                if(countIdx == input.length())
                    break;
            }
                    // a a b c c c c a a a
            //base  // 0
            //count // 0 1 2

            // Done with one base - add to output
            output.append(baseChar);     //a
            output.append(currentCount); //2

            // set indices for next iteration
            baseIdx = countIdx;
            currentCount = 0;
        }

        if(output.toString().length() >= input.length())
            return input;
        else
            return output.toString();
    }

    // Not use StringBuffer
    public static String stringcomp_2(String input){
        String[] output = new String[input.length()];

        int baseIdx = 0;
        int outputIdx = 0;
        int currentCount = 0;
        char baseChar = input.charAt(baseIdx);


        while(baseIdx < input.length()){
            // same char
            if (baseChar == input.charAt(baseIdx)){
                currentCount++;
                baseIdx++;
            }else{
                output[outputIdx] = String.valueOf(baseChar); // String.valueOf
                outputIdx++;
                output[outputIdx] = String.valueOf(currentCount);
                outputIdx++;
                currentCount = 0;
                baseChar = input.charAt(baseIdx);
            }
        }

        output[outputIdx] = String.valueOf(baseChar); // String.valueOf
        outputIdx++;
        output[outputIdx] = String.valueOf(currentCount);

        return Arrays.toString(output);
    }


    public static void main(String[] args) {
        System.out.println(stringcomp_1("aabccccaaadddddddddddddddddd"));
    }
}
