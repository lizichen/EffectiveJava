package InterviewQuiz;

/**
 * Created by lizichen1 on 7/28/18.
 */
public class Bloomberg_RectangleOverlap_836 {
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int Ax1 = rec1[0];
        int Ay1 = rec1[1];
        int Ax2 = rec1[2];
        int Ay2 = rec1[3];

        int Bx1 = rec2[0];
        int By1 = rec2[1];
        int Bx2 = rec2[2];
        int By2 = rec2[3];

        if(Ax1 <= Bx1 && Ax2 <= Bx1){
            return false;
        }else if(Ax1 >= Bx2 && Ax2 >= Bx2){
            return false;
        }else if(Ay1 <= By1 && Ay2 <= By1){
            return false;
        }else if(Ay1 >= By2 && Ay2 >= By2){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1, 1, 3, 3}));
    }

}
