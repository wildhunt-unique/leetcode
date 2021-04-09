package tooffer;

import base.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 *
 * @author 丁星（镜月）
 * @since 2021-04-02
 */
public class IsBalanced {
    public static void main(String[] args) {
        String x = "you have an apple";
        System.out.println(x.substring(2, 6));
    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        getHeight(root);
        return flag;
    }

    private int getHeight(TreeNode root) {
        if (null == root || !flag) {
            return 0;
        }

        int lh = getHeight(root.left);
        int hg = getHeight(root.right);
        int diff = lh - hg;
        diff = diff < 0 ? diff * -1 : diff;
        if (diff > 1) {
            flag = false;
        }

        return lh > hg ? lh + 1 : hg + 1;
    }


}
