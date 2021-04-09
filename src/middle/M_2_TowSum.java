package middle;

import base.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *
 * @author dx DingXing
 * @since 2021-01-26
 */
public class M_2_TowSum {

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.of(new int[]{9, 9, 9, 9});
        System.out.println(new M_2_TowSum().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int up = 0;

        ListNode point = null;
        while (l1 != null || l2 != null || up > 0) {
            int vl1 = l1 != null ? l1.val : 0;
            int vl2 = l2 != null ? l2.val : 0;
            int cur = vl1 + vl2 + up;
            up = cur / 10;

            ListNode current = new ListNode(cur % 10);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (point != null) {
                point.next = current;
            } else {
                result = current;
            }
            point = current;
        }

        return result;
    }
}


