package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();
        List<Integer> oneResult = new ArrayList();

        if(root == null)
            return result;

        Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
        levelQueue.add(root);
        levelQueue.add(new TreeNode(Integer.MAX_VALUE));

        while(levelQueue != null){
            TreeNode aNode = (TreeNode)levelQueue.remove();
            if(aNode.val != Integer.MAX_VALUE){
                oneResult.add(aNode.val);
                if(aNode.left != null){
                    levelQueue.add(aNode.left);
                }
                if(aNode.right != null){
                    levelQueue.add(aNode.right);
                }
            }else{
                result.add(oneResult);
                // very important to remember the break case
                if(levelQueue.size() == 0){
                    break;
                }
                oneResult = new ArrayList();
                levelQueue.add(aNode);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        levelOrder(root);
    }
}
