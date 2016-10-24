package Tree;

/**
 * Created by lizichen1 on 10/1/16.
 */
public class SumTreeNodeValues {

    public static void main(String[] args) {
        TreeNode3 root = TreeFactory.createArbitraryTree();
        TreeNode root_2 = TreeFactory.createIntegerBinaryTree(new int[]{1,9,2,8,3,7,4,6,5});

        TreeFactory.printAllRootToLeafPaths(root, 6);

        SumTreeNodeValues sumTreeNodeValues = new SumTreeNodeValues();
        sumTreeNodeValues.sumTheNodes(root);
        TreeFactory.printAllRootToLeafPaths(root, 6);

        sumTreeNodeValues.sumTheNodes_2(root_2);
    }

    private int sumTheNodes(TreeNode3 currentNode){
        int value = currentNode.getVal();
        if(currentNode.getChildren().size() == 0){
            return value;
        }else{
            int sumOfSubNodes = 0;
            for(TreeNode3 v: currentNode.getChildren()) {
                sumOfSubNodes += sumTheNodes(v);
                currentNode.setVal(value + sumOfSubNodes);
            }
            return currentNode.getVal();
        }
    }

    private int sumTheNodes_2(TreeNode currentNode){
        int value = currentNode.val;
        if(currentNode.left==null && currentNode.right == null){
            return value;
        }
        else{
            int sumOfSubNodes = 0;
            sumOfSubNodes += sumTheNodes_2(currentNode.left);
            sumOfSubNodes += sumTheNodes_2(currentNode.right);
            currentNode.val = sumOfSubNodes;
        }
        return currentNode.val;

    }
}
