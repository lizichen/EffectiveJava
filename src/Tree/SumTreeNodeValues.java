package Tree;

/**
 * Created by lizichen1 on 10/1/16.
 */
public class SumTreeNodeValues {

    public static void main(String[] args) {
        TreeNode3 root = TreeFactory.createArbitraryTree();
        TreeFactory.printAllRootToLeafPaths(root, 6);

        SumTreeNodeValues sumTreeNodeValues = new SumTreeNodeValues();
        sumTreeNodeValues.sumTheNodes(root);
        TreeFactory.printAllRootToLeafPaths(root, 6);
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
}
