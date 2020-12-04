/**
 * 二叉查找树
 *
 * @author ylqq
 */
public class BST {
    private int count = 0;
    private int val;

    /**
     * 只保留值在 L ~ R 之间的节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            //如果节点数字比low还要小，说明该节点左边的节点都不在L-H之间，将其裁掉
            root = root.right;
            //裁掉左子树后继续看右子树的情况，剪裁后重新赋值给root
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            //如果节点数字比high还要大，说明该节点右边的节点都不在L-H之间，将其裁掉
            root = root.left;
            //裁掉右子树后继续看左子树的情况，剪裁后重新复制给root
            root = trimBST(root, low, high);
        } else {
            //如果该节点数字在L-H区间内，就去剪裁他的左右子树
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }

    /**
     * 寻找二叉查找树的第 k 个元素
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return val;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        count++;
        if (count == k) {
            val = node.val;
            return;
        }
        inOrder(node.right, k);
    }


    /**
     * 二叉查找树的最近公共祖先
     * */
    private int sum=0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val>q.val&& root.val> p.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val< q.val&&root.val< p.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

}
