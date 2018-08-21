package Tree;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {

    Stack<TreeNode> s = new Stack();

    public BinarySearchTreeIterator_173(TreeNode root) {
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tn = s.pop();
        TreeNode r = tn.right;
        while(r!=null){
            s.push(r);
            r = r.left;
        }

        return tn.val;
    }

    public static void main(String[] args) {
        TreeNode r = TreeFactory.createBinaryTree();
        BinarySearchTreeIterator_173 it = new BinarySearchTreeIterator_173(r);
        it.next();
    }

}
