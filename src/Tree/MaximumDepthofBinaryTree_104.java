package Tree;

/**
 * Created by lizichen1 on 10/12/16.
 *
 * Tag: Depth First Traversal
 */
public class MaximumDepthofBinaryTree_104 {


    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        System.out.println(maxDepth_1(root));
        System.out.println(maxDepth_2(root));
        System.out.println(maxDepth_3(root));
    }

    public static int maxDepth_1(TreeNode root) {

        if(root == null)
            return 0;

        if(root.left == null && root.right == null){
            return 1;
        }

        int depth_left = maxDepth_1(root.left) + 1;
        int depth_right = maxDepth_1(root.right) + 1;

        if(depth_left >= depth_right)
            return depth_left;
        else
            return depth_right;
    }

    public static int maxDepth_2(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1 + Math.max(maxDepth_2(root.left), maxDepth_2(root.right));
    }

    public static int maxDepth_3(TreeNode root) {
        return root==null ? 0 : Math.max(maxDepth_3(root.left), maxDepth_3(root.right))+1;
    }

}
