package tooffer;

import base.TreeNode;

import java.util.LinkedList;

/**
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * @author 丁星（镜月）
 * @since 2021-04-02
 */
public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.addFirst(root);
        int rst = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                rst++;
            }
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pollFirst();
                if (null != node.right) {
                    stack2.addFirst(node.right);
                }
                if (null != node.left) {
                    stack2.addFirst(node.left);
                }
            }

            if (!stack2.isEmpty()) {
                rst++;
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pollFirst();
                if (null != node.right) {
                    stack1.addFirst(node.right);
                }
                if (null != node.left) {
                    stack1.addFirst(node.left);
                }
            }
        }

        return rst;
    }
}
