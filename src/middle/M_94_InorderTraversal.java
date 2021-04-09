package middle;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * @author 丁星（镜月）
 * @since 2021-04-08
 */
@SuppressWarnings("all")
public class M_94_InorderTraversal {
    public static void main(String[] args) {
        System.out.println(new M_94_InorderTraversal().inorderTraversal(null));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return withStack(root);
    }

    private List<Integer> withStack(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            rst.add(root.val);
            root = root.right;
        }

        return rst;
    }


    private List<Integer> withLoop(TreeNode root) {
        if (null != root) {
            return new ArrayList<>();
        }

        List<Integer> rst = new ArrayList<>();
        innerLoop(root, rst);
        return rst;
    }

    private void innerLoop(TreeNode root, List<Integer> rst) {
        if (null == root) {
            return;
        }

        innerLoop(root.left, rst);

        rst.add(root.val);

        innerLoop(root.right, rst);
    }
}
