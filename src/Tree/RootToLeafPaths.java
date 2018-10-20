package Tree;

import util.Printer;

/**
 * Created by lizichen1 on 9/29/16.
 */
public class RootToLeafPaths {

    private int[] names;

    public RootToLeafPaths(int longestPath){
        this.names = new int[longestPath];
        for(int i=0 ; i<longestPath;i++){
            names[i] = 0;
        }
    }
/*
    public static void main(String[] args) {
        int longestPath = 10;
        RootToLeafPaths rootToLeafPaths = new RootToLeafPaths(longestPath);
        TreeNode3 root = TreeFactory.createArbitraryTree();
        rootToLeafPaths.DFS(root,0);
        rootToLeafPaths.DFS_NoRoot(root,0);
    }

    private void DFS(TreeNode3 root, int index) {
        this.names[index] = root.val;
        if( root.isLeaf() ){
            System.out.println(Printer.printIntArrayToString(this.names, index));
        }
        else{
            for (TreeNode3 node:root.getChildren()){
                DFS(node, index+1);
            }
        }
    }

    private void DFS_NoRoot(TreeNode3 root, int index) {
        for(TreeNode3 node:root.getChildren()){
            this.names[index] = node.val;
            if( node.isLeaf() ){
                System.out.println(Printer.printIntArrayToString(this.names, index));
            }
            else{
                DFS_NoRoot(node, index+1);
            }
        }
    }*/

}
