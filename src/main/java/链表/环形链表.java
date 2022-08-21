package 链表;

/**
 * @Author:qijun
 * @Description
 * @Date 15:33 2021/11/27
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        while (head != null){
            if(head.val == Integer.MIN_VALUE){
                return true;
            }
            else {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }

        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }

        }
        return false;

    }

}
