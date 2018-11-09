package Tree;

import java.util.ArrayList;
import java.util.List;

/*
Ex. 2.31
DFSPath, traverses the tree rooted by vertex T.
Whenever a leaf l of T is reached, the code prints the names of the vertices on the path from T to l.
The DFS should store the names along the path in the array Names[1..n]
    and insert the name of the latest vertex to be visited every time the DFS depends a level in the tree.

global n set to a suitably large value, the array Names[1..n]
global the vertices in tree T, the lists child[v] for each v in T

 */
public class DFSPath {

    private int[] path;

    public DFSPath(int pathArraySize){
        this.path = new int[pathArraySize];
    }

    public void printDFSPath(TreeNode3 root, int index){

        this.path[index] = root.val;

        if(root.children.size() == 0){// root is a leaf
            printPath(this.path, index);
        }else{
            for (TreeNode3 node: root.children) { // Review:
                printDFSPath(node, ++index);
                index--;
            }
        }
    }

    private static void printPath(int[] path, int index){
        for(int i=0; i<= index; i++){
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }

    // Review: another recursive approach:
    // https://leetcode.com/problems/binary-tree-paths/description/
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        if(root != null)
            helper(root, "", result);
        return result;
    }

    public static void helper(TreeNode root, String path, List<String> list){
        if(root.left == null && root.right == null){
            list.add(path + root.val);
        }else{
            if(root.left != null)
                helper(root.left, path + root.val + "->", list);
            if(root.right != null)
                helper(root.right, path + root.val + "->", list);
        }
    }

    public static void main(String[] args) {
        int pathArraySize = 10;
        DFSPath dfsPath = new DFSPath(pathArraySize);
        dfsPath.printDFSPath(TreeFactory.createArbitraryTree(), 0);
    }
}
