package Tree;

import java.util.Stack;

/**
 * Postorder Iterative Binary Tree Traversal, using a stack
 * http://www.java2blog.com/2014/07/binary-tree-postorder-traversal-in-java.html
 */
public class PostorderIterativeTraversal {

    public static void postorderIter( TreeNode root) {
        if( root == null ) return;

        Stack<TreeNode> stack = new Stack<TreeNode>( );

        TreeNode current = root;

        while( true ) {
            if( current != null ) {
                if( current.right != null )
                    stack.push( current.right );
                stack.push( current );
                current = current.left;
                continue;
            }

            if( stack.isEmpty( ) )
                return;
            current = stack.pop( );

            if( current.right != null && ! stack.isEmpty( ) && current.right == stack.peek( ) ) {
                stack.pop( );
                stack.push( current );
                current = current.right;
            } else {
                System.out.print( current.val + " " );
                current = null;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode rootNode=TreeFactory.createBinaryTree();
        postorderIter(rootNode);
    }
}
