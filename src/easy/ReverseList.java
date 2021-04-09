package easy;

import base.ListNode;

/**
 * @author dx DingXing
 * @since 2021-03-08
 */
public class ReverseList {
    public static void main(String[] args) {
        System.out.println(new ReverseList().reverseList(
                ListNode.of(new int[]{1, 2, 3, 4, 5, 6, 7})
        ));
    }

    public ListNode reverseList(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode pre = head;
        ListNode aft = head.next;

        do {
            head.next = aft.next;
            aft.next = pre;

            pre = aft;
            aft = head.next;
        } while (null != aft);

        head.next = null;
        return pre;
    }
}
