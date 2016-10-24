package Tree;

import apple.laf.JRSUIUtils;

/**
 * Created by lizichen1 on 10/23/16.
 */
public class IdenticalBinaryTree {

    /**
     *  return type is integer
     */
    public static int isSameTree(TreeNode a, TreeNode b) {

        if(a==null && b== null)
            return 1;

        if(a!=null && b!=null){
            if(a.val == b.val)
                return 1 * isSameTree(a.left, b.left) * isSameTree(a.right, b.right);
            else
                return 0;
        }

        return 0;
    }

    /**
     *  return type is boolean
     */
    public static boolean isSameTree_boolean(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a!=null && b!= null)
            return (a.val == b.val)&&(isSameTree_boolean(a.left, b.left))&&(isSameTree_boolean(a.right, b.right));
        return false;
    }

    public static void main(String[] args) {
        int[] a_arr = {1,2,3};
        int[] b_arr = {1,2,3};
        TreeNode a = TreeFactory.createIntegerBinaryTree(a_arr);
        TreeNode b = TreeFactory.createIntegerBinaryTree(b_arr);

        System.out.println(IdenticalBinaryTree.isSameTree_boolean(a, b));
        System.out.println(IdenticalBinaryTree.isSameTree(a, b));
    }
}
