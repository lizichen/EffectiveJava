package BitManipulation;

/**
 * String s and String t
 *
 * t is a random shuffling of s with an additional letter,
 *
 * find the additional letter!
 */

public class FindTheDifference_389 {
    public static char findTheDifference1(String s, String t) {
        char c = 0;
        for (int i = 0; i < s.length(); ++i) {
            c ^= s.charAt(i);
            System.out.println((int)c);
        }
        for (int i = 0; i < t.length(); ++i) {
            c ^= t.charAt(i);
            System.out.println((int)c);
        }
        return c;
    }

    public static char findTheDifference2(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdbae";
        //expect e
        System.out.println(findTheDifference1(s, t));
    }

}
