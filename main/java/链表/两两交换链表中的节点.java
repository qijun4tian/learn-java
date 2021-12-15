package 链表;

import java.util.HashMap;

/**
 * @Author:qijun
 * @Description
 * @Date 23:05 2021/12/15
 */
public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode dmmy = new ListNode();
        dmmy.next = head.next;
        ListNode nextHead = head.next.next;
        ListNode newHead = dmmy.next;
        newHead.next = head;
        head.next = swapPairs(nextHead);
        return newHead;

    }
}
