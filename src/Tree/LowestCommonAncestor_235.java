package Tree;

/**
 * Created by lizichen1 on 7/29/18.
 *
 * Tree
 *
 * check follow up question:
 *          https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class LowestCommonAncestor_235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = p.val;
        int large = q.val;
        if(p.val > q.val){
            small = q.val;
            large = p.val;
        }

        if(small <= root.val && root.val <= large)
            return root;
        else if(large < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < small){ // root.val < small
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

}
