package Tree;

public class DeleteNodeInABST_450 {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        // create a dummy node for returning:
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        dummy.left = root;
        TreeNode prev = dummy;
        TreeNode cur = root;

        // since this is a BST, find the target node first
        while(cur!= null && cur.val != key){
            prev = cur;
            if(key == cur.val){
                break;
            }else if(key < cur.val){
                cur = cur.left;
            }else if(key > cur.val){
                cur = cur.right;
            }
        }

        if(cur == null){
            return root;
        }

        // now that we have found the key node, and its parent node, we can proceed:
        if(cur.left != null && cur.right != null){
            // we need to find a node to replace:
            // TreeNode prev2 = cur;
            // TreeNode cur2 = cur.right;
            // while(cur2.left != null){
            //     prev2 = cur2;
            //     cur2 = cur2.left;
            // }
            // cur.val = cur2.val;
            // if(prev2.left == cur2){
            //     prev2.left = null;
            // }else if(prev2.right == cur2){
            //     prev2.right = null;
            // }
            TreeNode target = cur;
            prev = cur;
            cur = cur.right;
            while(cur.left != null){
                prev = cur;
                cur = cur.left;
            }
            target.val = cur.val;
        }

        // Review: tricky part!
        if(cur.left == null){
            if(prev.left == cur){
                prev.left = cur.right;
            }else if(prev.right == cur){
                prev.right = cur.right;
            }
        }else if(cur.right == null){
            if(prev.left == cur){
                prev.left = cur.left;
            }else if(prev.right == cur){
                prev.right = cur.left;
            }
        }

        return dummy.left;
    }

}
