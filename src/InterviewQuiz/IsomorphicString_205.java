package InterviewQuiz;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Linkedin
 */
public class IsomorphicString_205 {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length() || s == null || t == null){
            return false;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // put s into hashtable
        HashMap sTable = new HashMap();
        HashSet values = new HashSet();

        for(int i=0; i<sArr.length; i++){
            if(sTable.get(sArr[i]) != null) {
                if(tArr[i] != (char)sTable.get(sArr[i]))
                    return false;
            }else{
                if(values.contains(tArr[i])){
                    return false;
                }
                sTable.put(sArr[i], tArr[i]);
                values.add(tArr[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
