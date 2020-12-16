import java.util.Random;

class ReConstructBinaryTree {
    public Node reConstructBinaryTree(int[] pre, int[] in) {
        int r = pre.length - 1;
        Node root = buildTree(pre, in, 0, r, 0, r);
        return root;
    }

    public Node buildTree(int[] pre, int[] in, int la, int ra, int lb, int rb) {
        if (la > ra || lb > rb) {
            return null;
        }
        //先序第一个是根节点
        int rt = pre[la];
        Node root = new Node(rt);

        //跟节点在中序遍历中的位置
        int load = lb;
        while (in[load] != rt && load < rb) {
            load++;
        }

        //左字数节点数
        int num = load - lb;
        root.left = buildTree(pre, in, la + 1, la + num, lb, load - 1);
        root.right = buildTree(pre, in, la + num + 1, ra, load + 1, rb);
        return root;

    }
}

/**
 * @author ylqq
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        //新建一个随机数组测试
        Random random = new Random();
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            int num = random.nextInt();
            a[i] = num;
        }

        binaryTree.buildTree(a);

        System.out.println("二叉树的中序遍历:");
        binaryTree.inOrder();

        System.out.println("二叉树的先序遍历：");
        binaryTree.preOrder();

        System.out.println("二叉树的后序遍历：");
        binaryTree.postOrder();

    }

    /**
     * 二叉查找树的插入
     * */
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            //寻找插入位置
            while (true) {
                parent = current;
                //如果要插入的数据比当前节点的大，节点左移
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        //当找到目标节点时，将节点插入，然后结束函数
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void buildTree(int[] data) {
        for (int datum : data) {
            insert(datum);
        }
    }

    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void inOrder() {
        this.inOrder(this.root);
    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void preOrder() {
        this.preOrder(this.root);
    }

    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.println(localRoot.data + ' ');
        }
    }

    public void postOrder() {
        this.postOrder(this.root);
    }

}
