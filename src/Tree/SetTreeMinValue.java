package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lizichen1 on 10/24/16.
 *
 * Each Tree Vertex v has v.val and v.min.
 * v.min is initialized with 0
 * Set v.min as the smallest number in v's subtree.
 */
public class SetTreeMinValue {

    public static void main(String[] args) {

        TreeNode4 rootNode = createIntegerBinaryTree(new int[]{1,9,2,8,3,7,4,6,5});
        SetTreeMinValue.setMin(rootNode);
    }

    private static void setMin(TreeNode4 rootNode) { /* Trick part: return is void*/
        rootNode.val2 = rootNode.val1;
        if(rootNode.left!=null && rootNode.right!=null) {
            setMin(rootNode.left);
            setMin(rootNode.right);
            if (rootNode.val2 > (rootNode.left).val2)
                rootNode.val2 = (rootNode.left).val2;
            if (rootNode.val2 > (rootNode.right).val2)
                rootNode.val2 = (rootNode.right).val2;
        }
    }

    public static TreeNode4 createIntegerBinaryTree(int[] arr){
        Queue<TreeNode4> queue = new LinkedList();
        TreeNode4 rootNode =new TreeNode4(arr[0]);
        queue.add(rootNode);
        int i=1;
        while(queue.size()!=0){
            TreeNode4 inTreeNode = queue.poll();
            if(i == arr.length){
                break;
            }
            if(i < arr.length) {
                inTreeNode.left = new TreeNode4(arr[i++]);
                queue.add( inTreeNode.left);
            }
            if(i < arr.length) {
                inTreeNode.right = new TreeNode4(arr[i++]);
                queue.add( inTreeNode.right);
            }
        }
        return rootNode;
    }
}
