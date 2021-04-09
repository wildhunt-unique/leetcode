package tooffer;

import base.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * @author 丁星（镜月）
 * @since 2021-03-23
 */
public class IsSymmetric_28 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);

        TreeNode l4 = new TreeNode(4);
        TreeNode r3 = new TreeNode(3);


        IsSymmetric_28 test = new IsSymmetric_28();
        System.out.println(test.isSymmetric(r1));

    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode l, TreeNode r) {
        if (null == l && null == r) {
            return true;
        }
        if (null == l || null == r) {
            return false;
        }

        if (l.val != r.val) {
            return false;
        }

        return isSym(l.left, r.right) && isSym(l.right, r.left);

    }
}
