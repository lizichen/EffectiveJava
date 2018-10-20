package InterviewQuiz;

// not on leetcode

public class Bloomberg_RemoveConsecutiveThree {
    public static String removeConsecutive(String s) {
        for (int i=0,j=0; j<s.length(); j++) {

            if (s.charAt(i) == s.charAt(j)) // increment j until we see a different char
                continue;

            if (j-i >= 3) { // delete the repeating sequence with more than 3 chars
                return removeConsecutive(s.substring(0,i) + s.substring(j));
            }
            else { // search repetition for a new char
                i = j;
            }
        }
        return s;
    }

    // Test case:
    public static void main(String[] args) {
        String input1 = "AABBCCCCDD";
        String input2 = "AABBCCCCBADD";
        System.out.println(input1 + " => " + removeConsecutive(input1));
        System.out.println(input2 + " => " + removeConsecutive(input2));
    }
}
