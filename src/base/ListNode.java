package base;

/**
 * @author dx DingXing
 * @since 2021-03-08
 */
@SuppressWarnings("all")
public class ListNode {
    public volatile int val;
    public ListNode next;


    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] x) {
        ListNode head = new ListNode(x[0]);
        ListNode point = head;
        for (int i = 1; i < x.length; i++) {
            ListNode current = new ListNode(x[i]);
            point.next = current;
            point = current;
        }
        return head;
    }

    @Override
    public String toString() {
        return this.val + (this.next != null ? ", " + this.next.toString() : "");
    }
}
