package Tree;

public class ClosestBinarySearchTreeValue_270 {
    double dif = Integer.MAX_VALUE;
    double target = 0;
    int closestVal;

    public int closestValue(TreeNode root, double target) {
        this.target = target;
        this.dif = Math.abs(root.val - target);
        this.closestVal = root.val;
        helper(root);
        return closestVal;
    }

    public void helper(TreeNode root){
        System.out.println("closestVal = "+closestVal);
        if(root == null)
            return ;
        else if(root.val == target){
            dif = 0.0;
            closestVal = root.val;
        }else if(root.val < target){
            if(dif > Math.abs(root.val - target)){
                closestVal = root.val;
                dif = Math.abs(root.val - target);
            }
            helper(root.right);
        }else if(root.val > target){
            if(dif > Math.abs(root.val - target)){
                closestVal = root.val;
                dif = Math.abs(root.val - target);
            }
            helper(root.left);
        }
    }

    // Much concise solution:
    public int closestValue2(TreeNode root, double target) {
        int a = root.val;
        TreeNode kid = target < a ? root.left : root.right;
        if (kid == null)
            return a;
        int b = closestValue(kid, target);
        return Math.abs(a - target) < Math.abs(b - target) ? a : b;
    }

    public static void main(String[] args) {
        TreeNode root = TreeFactory.createBinaryTreeFromArray(new int[]{4,2,5,1,3});
        ClosestBinarySearchTreeValue_270 testclass = new ClosestBinarySearchTreeValue_270();
        System.out.println(testclass.closestValue(root, 2));
    }

}
