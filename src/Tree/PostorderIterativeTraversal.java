package Tree;

/**
 * Created by lizichen1 on 9/26/16.
 */
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

    public static TreeNode createBinaryTree() {

        TreeNode rootNode =new TreeNode(40);
        TreeNode node20=new TreeNode(20);
        TreeNode node10=new TreeNode(10);
        TreeNode node30=new TreeNode(30);
        TreeNode node60=new TreeNode(60);
        TreeNode node50=new TreeNode(50);
        TreeNode node70=new TreeNode(70);

        rootNode.left=node20;
        rootNode.right=node60;

        node20.left=node10;
        node20.right=node30;

        node60.left=node50;
        node60.right=node70;

        return rootNode;
    }

    public static void main(String[] args) {
        TreeNode rootNode=createBinaryTree();
        postorderIter(rootNode);
    }
}
