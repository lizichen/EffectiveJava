package Tree;
import java.util.ArrayList;

/**
 * Created by lizichen1 on 9/19/16.
 */
public class TreeNode3 {
    int val;
    ArrayList<TreeNode3> children = new ArrayList<>();

    TreeNode3(int x) {
        val = x;
    }

    public void addChild(TreeNode3 x){
        this.children.add(x);
    }

    public int getVal(){
        return this.val;
    }

    public void setVal(int val1){
        this.val = val1;
    }

    public ArrayList<TreeNode3> getChildren(){
        return this.children;
    }

    public boolean isLeaf(){
        if(this.children.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
