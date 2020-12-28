

/**
 * @author ylqq
 */
public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {
          this.data = val;
          this.left = left;
          this.right = right;
      }
}
