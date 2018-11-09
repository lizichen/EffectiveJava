package BinarySearch;


import Tree.TreeFactory;
import Tree.TreeNode;
import util.Printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Given a binary search tree
// find all elements with in min and max
// follow up
// return the elements in order
public class Bloomberg_BSTValuesWithinRange {

    // BFS - iterative
    public List<Integer> findValuesInRange(TreeNode root, int min, int max){
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode n = q.poll();
                if(isValid(n.val, min, max)){
                    result.add(n.val);
                    addChildrenNodeToQueue(n, q);
                }
            }
        }

        return result;
    }

    // DFS - recursive
    public List<Integer> findValuesInRange2(TreeNode root, int min, int max){
        List<Integer> result = new ArrayList<>();
        recursiveHelper(root, result, min, max);
        return result;
    }

    private void recursiveHelper(TreeNode root, List<Integer> result, int min, int max) {
        if(root != null){
            recursiveHelper(root.left, result, min, max);
            if(isValid(root.val, min, max)){
                result.add(root.val);
            }
            recursiveHelper(root.right, result, min, max);
        }
    }

    // morris inorder traversal
    public List<Integer> morris(TreeNode root, int min, int max) {
        List<Integer> result = new ArrayList<>();

        TreeNode current;
        TreeNode pre;

        if (root == null)
            return result;

        current = root;
        while (current != null) {
            if (current.left == null) {
                if(isValid(current.val, min, max))
                    result.add(current.val);
                current = current.right;
            }
            else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made in if part to restore the original tree i.e., fix the right child of predecssor*/
                else {
                    pre.right = null;
                    if(isValid(current.val, min, max))
                        result.add(current.val);
                    current = current.right;
                } /* End of if condition pre->right == NULL */
            } /* End of if condition current->left == NULL*/
        } /* End of while */
        return result;
    }

    private void addChildrenNodeToQueue(TreeNode n, Queue<TreeNode> q) {
        if(n.left != null)
            q.add(n.left);
        if(n.right != null)
            q.add(n.right);
    }

    private boolean isValid(int val, int min, int max) {
        return (min < val && val < max);
    }

    public static void main(String[] args) {
        Bloomberg_BSTValuesWithinRange sol = new Bloomberg_BSTValuesWithinRange();

        TreeNode BST = TreeFactory.createBinaryTreeFromArray(new int[]{6,4,8,3,5,7,9});
//        sol.morris(BST, 3, 9);
        List<Integer> solution = sol.morris(BST, 3,9);
        Printer.printList(solution);
    }
}
