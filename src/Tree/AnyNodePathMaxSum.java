package Tree;

import java.util.List;

/**
 * Given a binary tree, return the sum of a path from any node to any node, not necessary from leaf node or root,
 * the start and end can be any node as long as it's on a single path.
 *
 */
public class AnyNodePathMaxSum {

    static int max = 0;

    public static int maxPath(TreeNode root){
        if(root == null)
            return 0;
        else{
            int left = maxPath(root.left);
            int right = maxPath(root.right);
            max = Math.max(max, left + right + root.val);
            return Math.max(left, right)+root.val;
        }
    }

    //TODO: print the path of the max sum?
    public static List<Integer> printMaxPath(TreeNode root){

        return null;
    }

    public static void main(String[] args) {
        String arrStr = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = TreeFactory.createBinaryTreeFromArrayWithEmptySpace(arrStr);
        maxPath(root);
        System.out.println("Max Path = "+max);
    }
}
