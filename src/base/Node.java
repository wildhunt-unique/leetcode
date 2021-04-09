package base;

/**
 * @author 丁星（镜月）
 * @since 2021-04-07
 */
@SuppressWarnings("all")
public class Node {
    public Node left;
    public Node right;
    public String value;
    public int val;

    public Node(String value) {
        this.value = value;
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        String rst = value == null ? "" + this.val : value;
        if (this.left != null) {
            rst = rst + "," + this.left.toString();
        }

        if (this.right != null) {
            rst = rst + "," + this.right.toString();
        }
        return rst;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
