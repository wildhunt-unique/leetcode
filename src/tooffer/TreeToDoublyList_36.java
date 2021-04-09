package tooffer;

import base.Node;

/**
 * @author 丁星（镜月）
 * @since 2021-04-07
 */
public class TreeToDoublyList_36 {
    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        mfs(root);
        head.left = last;
        last.right = head;
        return head;
    }

    private Node head = null;
    private Node last = null;
    private Node pre = null;

    private void mfs(Node root) {
        if (null == root) {
            return;
        }

        mfs(root.left);

        // 记录尾节点
        last = root;
        // 头节点
        if (head == null) {
            head = root;
        }
        if (null != pre) {
            pre.right = root;
            root.left = pre;
        }
        pre = root;

        mfs(root.right);
    }
}
