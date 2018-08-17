package Tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2_107 {

    // BFS is trivial
    // Review: Recursive DFS approach:
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTree();
        levelOrderBottom(root);
    }

}
