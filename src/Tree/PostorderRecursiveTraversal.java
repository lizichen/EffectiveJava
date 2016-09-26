package Tree;
import java.util.ArrayList;

/**
 * Created by lizichen1 on 9/19/16.
 */
public class PostorderRecursiveTraversal {
    public static void main(String[] args) {

//        TreeNode root = buildGeneralBineryTree();
//        postOrder1(root);

        TreeNode3 root3 = buildGeneralTernaryTree();
        postOrder3(root3);
    }

    public static void postOrder1(TreeNode root){
        if(root == null)
            return;
        postOrder1( root.left );
        postOrder1( root.right );
        System.out.print(" "+root.val);
    }

    public static void postOrder3(TreeNode3 root){
        // solution 1
//        if( root == null )
//            return;
//        else
//            for (TreeNode3 t : root.children) {
//                postOrder3(t);
//            }
//            System.out.print(" "+root.val);

        // solution 2
        if (root != null){
            for (TreeNode3 t : root.children) {
                postOrder3(t);
            }
            System.out.print(" "+root.val);
        }
    }

    public static TreeNode buildGeneralBineryTree(){
        TreeNode root = new TreeNode(7);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(15);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(8);
        TreeNode f = new TreeNode(21);

        ArrayList<TreeNode> treeNodeArrayList = new ArrayList<>();
        treeNodeArrayList.add(root);
        treeNodeArrayList.add(a);
        treeNodeArrayList.add(b);
        treeNodeArrayList.add(c);
        treeNodeArrayList.add(d);
        treeNodeArrayList.add(e);
        treeNodeArrayList.add(f);

        root.left = a;
        root.right = b;

        a.left = c; a.right = d;
        b.left = e; b.right = f;

        return root;
    }

    public static TreeNode3 buildGeneralTernaryTree(){
        TreeNode3 a = new TreeNode3(1);
        TreeNode3 b = new TreeNode3(2);
        TreeNode3 c = new TreeNode3(3);
        TreeNode3 d = new TreeNode3(4);
        TreeNode3 e = new TreeNode3(5);
        TreeNode3 f = new TreeNode3(6);
        TreeNode3 g = new TreeNode3(7);
        TreeNode3 h = new TreeNode3(8);
        TreeNode3 i = new TreeNode3(9);
        TreeNode3 j = new TreeNode3(10);

        a.children = new ArrayList<TreeNode3>();
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);

        b.children = new ArrayList<TreeNode3>();
        b.children.add(e); b.children.add(f);

        c.children = new ArrayList<TreeNode3>();
        c.children.add(g);

        d.children = new ArrayList<TreeNode3>();
        d.children.add(h);d.children.add(i); d.children.add(j);

        return a;
    }
}


