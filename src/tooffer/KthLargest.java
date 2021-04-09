package tooffer;

import base.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点
 *
 * @author 丁星（镜月）
 * @since 2021-04-02
 */
public class KthLargest {


    public static void main(String[] args) {

    }

    private int[] rst = new int[]{0};
    private int[] cur = new int[]{0};
    private boolean breakDown = false;


    public int kthLargest(TreeNode root, int k) {
        this.dfs(root, k);
        return rst[0];
    }

    private void dfs(TreeNode root, int k) {
        if (breakDown || root == null) {
            return;
        }

        dfs(root.right, k);
        cur[0]++;
        if (cur[0] == k) {
            breakDown = true;
            rst[0] = root.val;
        }
        dfs(root.left, k);
    }


}
