package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/description/
public class PathSum2_113 {

    // Review:
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> aRes = new ArrayList();
        if(root == null)
            return res;

        helper(res, aRes, root, sum);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> aRes, TreeNode root, int sum){
        if(root == null){
            return ;
        }

        if(root.left == null && root.right == null && sum - root.val == 0){
            aRes.add(root.val);
            res.add(new ArrayList(aRes));
        }else{
            aRes.add(root.val);
            helper(res, aRes, root.left, sum - root.val);
            helper(res, aRes, root.right, sum - root.val);
        }
        aRes.remove(aRes.size() - 1);
    }

    // Review:
//    public static List<List<Integer>> pathSum2(TreeNode root, int sum){
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> aRes = new ArrayList<>();
//        int currentSum = 0;
//        if(root != null){
//            helper2(root, sum, currentSum, res, aRes);
//        }
//        return res;
//    }
//
//    public static void helper2(TreeNode root, int sum, int currentSum, List<List<Integer>> res, List<Integer> aRes){
//        if(root != null && sum == currentSum+root.val){
//            if(root.left == null && root.right == null){
//                aRes.add(root.val);
//                res.add(new ArrayList<>(aRes));
//            }
//        }else if(root == null){
//            return ;
//        }else{
//            aRes.add(root.val);
//            helper2(root.left, sum, currentSum + root.val, res, aRes);
//            helper2(root.right, sum, currentSum + root.val, res, aRes);
//            aRes.remove(aRes.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        String arrStr = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        int target = 22;
//        String arrStr = "[1,2]";  int target = 1;
        TreeNode root = TreeFactory.createBinaryTreeFromArrayWithEmptySpace(arrStr);
        List<List<Integer>> r = pathSum(root, target);
        for(List<Integer> i:r){
            System.out.println(i);
        }

    }
}
