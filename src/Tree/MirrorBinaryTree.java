package Tree;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * Easy to mistaken with SymmetricBinaryTree_101
 *
 * Tag. Recursion, Tree traversal
 */
public class MirrorBinaryTree {

    public static void main(String[] args) {
        MirrorBinaryTree mirrorBinaryTree = new MirrorBinaryTree();
        TreeNode root = TreeFactory.createBinaryTree();

        mirrorBinaryTree.mirrorTheTree(root);
    }

    public void mirrorTheTree(TreeNode root){
        if(root.left!=null && root.right!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.left!=null || root.right!=null) {
            mirrorTheTree(root.left);
            mirrorTheTree(root.right);
        }
    }

}
