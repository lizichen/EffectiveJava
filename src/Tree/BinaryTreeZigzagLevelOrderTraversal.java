package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizichen1 on 7/28/18.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList();

        List<TreeNode> currentList = new ArrayList();
        currentList.add(root);
        boolean levelOrder = true; // true for odd level, false for even level

        while(currentList != null){
            // add to result first;
            addToResult(currentList, result, levelOrder);
            // breadth-first for each level, index with level
            currentList = bfsByLevel(currentList);

            levelOrder = levelOrder ? false : true;
        }

        return result;
    }

    // simply convert TreeNode to Integer for output
    public static void addToResult(List<TreeNode> currentList, List<List<Integer>> result, boolean levelOrder){
        List<Integer> currentIntegerList = new ArrayList();

        if(levelOrder){ // from left to right
            for(int i=0; i<currentList.size(); i++){
                currentIntegerList.add(currentList.get(i).val);
            }
        }else{ // from right to left
            for(int i=currentList.size() - 1; i>=0; i--){
                currentIntegerList.add(currentList.get(i).val);
            }
        }

        if(currentIntegerList.size() != 0)
            result.add(currentIntegerList);
    }

    public static List<TreeNode> bfsByLevel(List<TreeNode> currentList){
        List<TreeNode> currentLevelResult = new ArrayList();

        for(int i=0; i<currentList.size(); i++){
            TreeNode node = currentList.get(i);
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left != null)
                currentLevelResult.add(left);
            if(right != null)
                currentLevelResult.add(right);
        }

        // before return,
        if(currentList.size() == 0){
            return null;
        }else{
            return currentLevelResult;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        zigzagLevelOrder(root);
    }

}
