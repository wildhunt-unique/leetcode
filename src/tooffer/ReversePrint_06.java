package tooffer;

import base.ListNode;

import java.util.Arrays;

/**
 * 反转打印
 *
 * @author dx DingXing
 * @since 2021-03-13
 */
public class ReversePrint_06 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ReversePrint_06().reversePrint(ListNode.of(new int[]{1, 2, 3, 4, 5, 6, 7}))));
    }

    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[]{};
        }

        int n = 1;
        ListNode tmp = head;
        while (null != tmp.next) {
            tmp = tmp.next;
            n++;
        }
        int[] rst = new int[n];
        addToRst(head, rst);
        return rst;
    }

    private int addToRst(ListNode head, int[] rst) {
        if (head.next == null) {
            rst[0] = head.val;
            return 1;
        }
        int n = addToRst(head.next, rst);
        rst[n] = head.val;
        return n + 1;
    }

}
