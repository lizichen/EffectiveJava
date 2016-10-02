package Tree;

/**
 * Created by lizichen1 on 9/27/16.
 */
public class TreeFactory {

    public static TreeNode createBinaryTree(){
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

    /**
     *                 7   _
     *              /  |    \
     *             4   8     12
     *       / / / |   | \ \
     *      1 2 3  5   9 10 11
     *             |
     *             6
     */
    public static TreeNode3 createArbitraryTree(){
        TreeNode3 node7 = new TreeNode3(7);
        TreeNode3 node4 = new TreeNode3(4);
        TreeNode3 node1 = new TreeNode3(1);
        TreeNode3 node2 = new TreeNode3(2);
        TreeNode3 node3 = new TreeNode3(3);
        TreeNode3 node5 = new TreeNode3(5);
        TreeNode3 node6 = new TreeNode3(6);

        TreeNode3 node8 = new TreeNode3(8);
        TreeNode3 node9 = new TreeNode3(9);
        TreeNode3 node10 = new TreeNode3(10);
        TreeNode3 node11 = new TreeNode3(11);
        TreeNode3 node12 = new TreeNode3(12);

        node7.addChild(node4);
        node7.addChild(node8);
        node7.addChild(node12);

        node4.addChild(node1);
        node4.addChild(node2);
        node4.addChild(node3);
        node4.addChild(node5);

        node5.addChild(node6);

        node8.addChild(node9);
        node8.addChild(node10);
        node8.addChild(node11);

        return node7;
    }

    public static void printAllLeaves(TreeNode3 root){

        if(root.getChildren().size() == 0){
            System.out.println(root.getVal());
        }else{
            for (TreeNode3 v:root.getChildren()) {
                printAllLeaves(v);
            }
        }
    }

    public static void printAllRootToLeafPaths(TreeNode3 root, int estLongestPath){
        DFSPath d = new DFSPath(estLongestPath);
        d.printDFSPath(root, 0);
    }
}
