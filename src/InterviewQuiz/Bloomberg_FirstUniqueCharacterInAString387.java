package InterviewQuiz;

public class Bloomberg_FirstUniqueCharacterInAString387 {

    public int firstUniqChar(String s) {
        // try use int[]
        int[] frequency = new int[26];
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            frequency[arr[i] - 'a']++;
        }
        for(int i=0; i<s.length(); i++){
            if(frequency[arr[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }

}
