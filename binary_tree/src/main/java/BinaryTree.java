import java.util.Random;

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
