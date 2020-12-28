/**
 * @author ylqq
 */
public class Tree {
    private int count=0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return count;
        }
        while(root.left!=null&&root.right!=null){
            isSum(root,sum);
        }
        return count;
    }
    private int isSum(TreeNode root,int sum){
        if(root==null){
            return count;
        }
        if(root.right==null&&root.left==null&&root.val!=sum){
            root=null;
            return count;
        }
        if(root.right==null&&root.left==null&&root.val==sum){
            return count++;
        }
        isSum(root.left,sum-root.val);
        isSum(root.right,sum-root.val);
        return count;
    }


    public static void main(String[] args) {

    }
}
