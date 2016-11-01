package Tree;

/**
 *                 7   _
 *              /  |    \
 *             4   8     12
 *       / / / |   | \ \
 *      1 2 3  5   9 10 11
 *             |
 *             6
 *
 *
 *             after Rorate this tree by 1 with 100
 *             we have a pre-order traversal sequence:
 *             100, 7, 4, 1, 2, 3, 5, 6, 8, 9, 10, 11.
 *             And the node 12 should be out of the tree as the return.
 */
public class RotateTreePreorder {

    public static void main(String[] args) {
        TreeNode3 root = TreeFactory.createArbitraryTree();
        TreeFactory.printAllRootToLeafPaths(root, 10);
        int newValue = 100;

        int kickedout =  Rotate_func(root, newValue);
        System.out.println(kickedout);
        TreeFactory.printAllRootToLeafPaths(root, 10);
    }

    /**
     * Base case: when there is only root in the tree.
     *  1. get the value of the root,
     *  2. assign newValue to the root.
     *  3. return the value of the root.
     */
    private static int Rotate_func(TreeNode3 root, int newValue){
        int temp = root.getVal();
        root.setVal(newValue);
        for (TreeNode3 t:root.getChildren()) {
            temp = Rotate_func(t, temp);
        }
        return temp;
    }

}
