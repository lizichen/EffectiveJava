package Tree;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * Easy to mistaken with MirrorBinaryTree
 *
 * Tag. Recursion, Tree Traversal
 */
public class SymmetricBinaryTree_101 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,4,3};
        TreeNode root = TreeFactory.createIntegerBinaryTree(arr);
        System.out.print("Is Symmetric: "+ isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        System.out.println("p = "+p.val+" q = "+q.val);
        return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
