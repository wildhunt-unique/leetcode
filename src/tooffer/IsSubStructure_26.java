package tooffer;

import base.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * @author 丁星（镜月）
 * @since 2021-03-22
 */
public class IsSubStructure_26 {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);

        n3.left = n4;
        n3.right = n5;
        n4.left = n1;
        n4.right = n2;

        TreeNode t4 = new TreeNode(4);
        t4.left = new TreeNode(2);
        System.out.println(new IsSubStructure_26().isSubStructure(n3, t4));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }

        if (A.val == B.val) {
            return isSub(A, B);
        }

        if (isSubStructure(A.left, B)) {
            return true;
        } else {
            return isSubStructure(A.right, B);
        }
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (null == B) {
            return true;
        }
        if (null == A) {
            return false;
        }

        if (A.val != B.val) {
            return false;
        }

        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }

}
