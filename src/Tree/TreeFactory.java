package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class TreeFactory {

    public static void main(String[] args) {
//        String arrStr = "[5,4,8,1,7,1,4,7,2,8,9,5,1]";
//        TreeNode root = createBinaryTreeFromArray(arr);

        String arrStr = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = createBinaryTreeFromArrayWithEmptySpace(arrStr);

        PrintBinaryTree_655 printer = new PrintBinaryTree_655();
        List<List<String>> res = printer.printTree(root);
        for(List<String> l:res){
            for(String s: l){
                System.out.print(s);
            }
            System.out.print("\n");
        }
    }

    public static TreeNode createBinaryTreeFromArray(int[] arr){
        System.out.println("Log: Creating binary tree from input array...");

        Queue<TreeNode> queue = new LinkedList();
        TreeNode rootNode =new TreeNode(arr[0]);
        queue.add(rootNode);
        int i=1;
        while(queue.size()!=0){
            TreeNode inTreeNode = queue.poll();
            if(i == arr.length){
                break;
            }
            if(i < arr.length) {
                inTreeNode.left = new TreeNode(arr[i++]);
                queue.add(inTreeNode.left);
            }
            if(i < arr.length) {
                inTreeNode.right = new TreeNode(arr[i++]);
                queue.add(inTreeNode.right);
            }
        }

        System.out.println("Log: Finished creating binary tree.");
        return rootNode;
    }

    // for Leetcode:
    // "[5,4,8,11,null,13,4,7,2,null,null,5,1]"
    public static TreeNode createBinaryTreeFromArrayWithEmptySpace(String arrStr){

        String[] intergerInStringArr = convertArrayStringToArrayList(arrStr);
        int arrIndex = 1;

        TreeNode root = new TreeNode(Integer.valueOf(intergerInStringArr[0]));

        Queue<TreeNode> leafqueue = new LinkedList<TreeNode>();
        leafqueue.add(root);

        while(!leafqueue.isEmpty()){
            TreeNode aNode = leafqueue.poll();
            if(arrIndex == intergerInStringArr.length){
                break;
            }

            if(arrIndex < intergerInStringArr.length){
                if (!intergerInStringArr[arrIndex].trim().equals("null")){
                    aNode.left = new TreeNode(Integer.valueOf(intergerInStringArr[arrIndex].trim()));
                    ((LinkedList<TreeNode>) leafqueue).add(aNode.left);
                }
                arrIndex++;
            }

            if(arrIndex < intergerInStringArr.length){
                if (!intergerInStringArr[arrIndex].trim().equals("null")){
                    aNode.right = new TreeNode(Integer.valueOf(intergerInStringArr[arrIndex].trim()));
                    ((LinkedList<TreeNode>) leafqueue).add(aNode.right);
                }
                arrIndex++;
            }
        }

        return root;
    }

    // input format:
    //      "[5,4,8,11,null,13,4,7,2,null,null,5,1]"
    public static String[] convertArrayStringToArrayList(String arrStr){
        return arrStr.substring(1, arrStr.length() - 1).split(",");
    }

    /**
     *          40
     *      20         60
     *   10    30     50   70
     *
     */
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
     *               5
     *            /     \
     *          2        7
     *         / \      /  \
     *        1   3    6    10
     *             \        /
     *              4      9
     *                    /
     *                   8
     *
     */
    public static TreeNode createIncompleteBinaryTree(){
        TreeNode node50 =new TreeNode(50); // root

        TreeNode node10=new TreeNode(10);
        TreeNode node20=new TreeNode(20);
        TreeNode node30=new TreeNode(30);
        TreeNode node40=new TreeNode(40);

        TreeNode node60=new TreeNode(60);
        TreeNode node70=new TreeNode(70);
        TreeNode node80=new TreeNode(80);
        TreeNode node90=new TreeNode(90);
        TreeNode node100=new TreeNode(100);

        node50.left = node20; node50.right = node70;

        node20.left = node10; node20.right = node30;
        node30.right = node40;

        node70.left = node60; node70.right = node100;
        node100.left = node90;
        node90.left = node80;

        return node50;
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

    // Printers

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

    public static void printBinaryTree(TreeNode root){
        PrintBinaryTree_655 printer = new PrintBinaryTree_655();

        List<List<String>> res = printer.printTree(root);
        for(List<String> l:res){
            for(String s: l){
                System.out.print(s);
            }
            System.out.print("\n");
        }
    }
}
