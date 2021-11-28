package 链表;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn2925/
 * @Author:qijun
 * @Description
 * @Date 11:48 2021/11/28
 */
public class 删除链表的倒数第N个节点 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next == null){
            return null;
        }
        slow.next = slow.next.next;
        return temp.next;


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        removeNthFromEnd(listNode,2);

    }
}
