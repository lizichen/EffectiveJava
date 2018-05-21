package util;

/**
 * Created by lizichen on 1/19/18.
 */
public class TestClass {
    public static void main(String[] args) {
        String str = "123 abc";
        int numSide = 2;
        char[] newStr = str.replaceAll("[^1-9a-zA-Z]*", "").substring(0, numSide).toCharArray();
        System.out.println(newStr);
    }
}
