package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {


    // BFS
    public List<Double> averageOfLevels(TreeNode root) {

        // practice BFS
        List<Double> result = new ArrayList();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            double sum = 0.0;
            for(int i=0; i<n; i++){
                TreeNode aNode = queue.remove();
                if(aNode.left != null){
                    queue.add(aNode.left);
                }
                if(aNode.right != null){
                    queue.add(aNode.right);
                }
                sum += aNode.val;
            }
            result.add(sum / n);
        }

        return result;
    }

    //TODO: review DFS approach

}
