package Array;

// Google On-site (Dec 6, 2018): Round 4
public class BackspaceStringComparison_844 {
    final static char BS = '<';
    public boolean backspaceCompare(String s1, String s2) {
        int idx1 = s1.length() - 1;
        int idx2 = s2.length() - 1;

        while (idx1 >= 0 || idx2 >= 0){
            if(idx1 >= 0 && s1.charAt(idx1) == BS)
                idx1 = validNext(idx1, s1);

            if(idx2 >= 0 && s2.charAt(idx2) == BS)
                idx2 = validNext(idx2, s2);

            if (idx1 >= 0 && idx2 >= 0 && s1.charAt(idx1) != s2.charAt(idx2))
                return false;

            if ((idx1 >= 0) != (idx2 >= 0))
                return false;

            idx1--;
            idx2--;
        }
        return true;
    }

    public int validNext(int idx, String s){
        int numberOfBS = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == BS) {
                numberOfBS++;
                idx--;
            } else if (numberOfBS > 0) {
                numberOfBS--;
                idx--;
            } else
                break;
        }
        return idx;
    }

    public static void main(String[] args) {
        BackspaceStringComparison_844 t = new BackspaceStringComparison_844();
        String s1 = "xywrrmp";
        String s2 = "xywrrmu<p";

        System.out.println(t.backspaceCompare(s1, s2));
    }

}
