package easy;

import base.TreeNode;
import thread.TreeBL;

import java.util.LinkedList;

/**
 * 二叉树公共祖先
 *
 * @author dx DingXing
 * @since 2021-03-11
 */
public class TreeCommonParent {
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");

        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");


        A.left = B;
        A.right = C;
        B.right = D;
        B.left = E;
        C.left = F;
        C.right = G;
        TreeNode[] treeNodes = {F, G};
        System.out.println(new TreeCommonParent().common(A, treeNodes));
    }

    public TreeNode common(TreeNode root, TreeNode[] toFinds) {
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        find(root, toFinds[0], stack1);

        LinkedList<TreeNode> stack2 = new LinkedList<>();
        find(root, toFinds[1], stack2);
        System.out.println(stack1);
        System.out.println(stack2);

        TreeNode last = root;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode s1 = null;
            if (!stack1.isEmpty()) {
                s1 = stack1.getFirst();
                stack1.remove(s1);
            }

            TreeNode s2 = null;
            if (!stack2.isEmpty()) {
                s2 = stack2.getFirst();
                stack2.removeFirst();
            }
            if (!s1.equals(s2) || s1 == null || s2 == null) {
                break;
            }
            last = s1;
        }

        return last;
    }

    private boolean find(TreeNode currentNode, TreeNode toFind, LinkedList<TreeNode> stack) {
        stack.add(currentNode);
        if (toFind.equals(currentNode)) {
            return true;
        }

        if (currentNode.left != null && find(currentNode.left, toFind, stack)) {
            return true;
        }

        if (currentNode.right != null && find(currentNode.right, toFind, stack)) {
            return true;
        }

        stack.remove(currentNode);
        return false;
    }
}
