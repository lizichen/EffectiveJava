package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveHelper(result, root);

        return result;
    }

    public static void recursiveHelper(List<Integer> result, TreeNode root){
        if(root == null){
            return ;
        }

        recursiveHelper(result, root.left);
        result.add(root.val);
        recursiveHelper(result, root.right);
    }


    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        inorderTraversal(root);
    }
}
