package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {

    // TODO: recursive traversal is trivial, try iterative traversal!
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

    public static List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> result = new ArrayList();
        if(root == null)return result;

        List<Integer> l = inorderTraversal(root.left);
        result.addAll(l);
        result.add(root.val);
        List<Integer> r = inorderTraversal(root.right);
        result.addAll(r);

        return result;
    }

    public static List<Integer> inorderTraversal_iterative(TreeNode root){
        List<Integer> result = new ArrayList();
        if(root == null)return result;

        Stack<TreeNode> s = new Stack<>();

        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            TreeNode tmp = s.pop();
            result.add(tmp.val);
            root = tmp.right; // Review:
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        inorderTraversal(root);
    }
}
