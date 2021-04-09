package base;

/**
 * @author dx DingXing
 * @since 2021-03-11
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String value;
    public int val;


    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode(int val) {
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
