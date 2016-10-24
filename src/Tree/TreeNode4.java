package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lizichen1 on 10/24/16.
 */
public class TreeNode4 {

    int val2;
    int val1;
    TreeNode4 left;
    TreeNode4 right;

    TreeNode4(int val, int val2) {

        this.val2 = val2;
    }

    TreeNode4(int val){
        this.val1 = val;
        this.val2 = 0;
    }


}
