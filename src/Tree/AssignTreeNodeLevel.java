package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lizichen1 on 10/5/16.
 */
public class AssignTreeNodeLevel {

    public static void assignLevels(TreeNode3 node){
        Queue<TreeNode3> queue = new LinkedList<>();
        TreeNode3 marker = new TreeNode3(Integer.MAX_VALUE);
        queue.add(node);
        queue.add(marker); /* Key: Add a marker to the Queue when incrementing the level.*/
        int level = 0;
        while(queue.size() > 1){ /* Easy to make mistakes here! */
            TreeNode3 temp = queue.poll();
            if(temp.getVal() == Integer.MAX_VALUE){
                level++;
                queue.add(marker);
            }
            else{
                temp.setVal(level);
                for(TreeNode3 child:temp.getChildren() ){
                    queue.add(child);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode3 root = TreeFactory.createArbitraryTree();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.BFS(root);
        System.out.println("After assigning levels...");
        AssignTreeNodeLevel.assignLevels(root);
        breadthFirstSearch.BFS(root);
    }
}
