package Tree;

import java.util.*;

/*Breadth First Search Traversal*/
public class BreadthFirstSearch {

    protected Queue<TreeNode3> queue = new LinkedList<>();

    public void BFS(TreeNode3 node){
        this.queue.add(node);
        while(this.queue.size()!=0){
            TreeNode3 n = this.queue.poll();
            System.out.print(n.getVal()+" ");
            for(TreeNode3 child:n.getChildren()){
                this.queue.add(child);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode3 root = TreeFactory.createArbitraryTree();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.BFS(root);
    }
}
