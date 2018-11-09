package Array;

public class RotateString_796 {

    public static boolean rotateString2(String A, String B){
        return (A.length() == B.length()) && (A+A).contains(B);
    }

    public static void main(String[] args) {
        String a = "abcded";
        String b = "cdedab";
        System.out.println(rotateString2(a, b));
    }
}
