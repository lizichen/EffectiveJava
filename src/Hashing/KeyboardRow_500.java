package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by lizichen1 on 3/19/17.
 */
public class KeyboardRow_500 {

    public static String[] findWords(String[] words) {
        //Build keyboard hashmap first:
        //<letter, rowNumber>
        HashMap keyboardRowMap = new HashMap();
        keyboardRowMap.put('Q', 1);
        keyboardRowMap.put('W', 1);
        keyboardRowMap.put('E', 1);
        keyboardRowMap.put('R', 1);
        keyboardRowMap.put('T', 1);
        keyboardRowMap.put('Y', 1);
        keyboardRowMap.put('U', 1);
        keyboardRowMap.put('I', 1);
        keyboardRowMap.put('O', 1);
        keyboardRowMap.put('P', 1);
        keyboardRowMap.put('A', 2);
        keyboardRowMap.put('S', 2);
        keyboardRowMap.put('D', 2);
        keyboardRowMap.put('F', 2);
        keyboardRowMap.put('G', 2);
        keyboardRowMap.put('H', 2);
        keyboardRowMap.put('J', 2);
        keyboardRowMap.put('K', 2);
        keyboardRowMap.put('L', 2);
        keyboardRowMap.put('Z', 3);
        keyboardRowMap.put('X', 3);
        keyboardRowMap.put('C', 3);
        keyboardRowMap.put('V', 3);
        keyboardRowMap.put('B', 3);
        keyboardRowMap.put('N', 3);
        keyboardRowMap.put('M', 3);

        ArrayList<String> resultwords = new ArrayList<>();
        int resultwordsIndex = 0;

        for(int i=0;i<words.length;i++){
            String currentword = words[i];
            int firstletterrow = (int) keyboardRowMap.get(currentword.toUpperCase().charAt(0));
            for(int j=0;j<currentword.length();j++){                                                    //NOTE: j has to start from 0
                if(firstletterrow == (int)keyboardRowMap.get(currentword.toUpperCase().charAt(j))){     // in case when input word is a single letter
                    if(j == currentword.length() - 1){
                        //resultwords[resultwordsIndex++] = currentword;
                        resultwords.add(currentword);
                        resultwordsIndex++;
                    }
                }else{
                    break;
                }
            }
        }

        return resultwords.toArray(new String[resultwordsIndex]);
    }

    public static void main(String[] args) {

        String[] result = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        System.out.println(Arrays.toString(result));
    }
}
