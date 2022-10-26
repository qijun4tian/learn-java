package 链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author:qijun
 * @Description
 * @Date 22:16 2021/11/25
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode temp =  stack.pop();
        ListNode head1 = temp;
        while (!stack.isEmpty()){
            ListNode temp1 =  stack.pop();
            temp1.next = null;
            temp.next = temp1;
            temp = temp1;

        }

        return head1;
    }
}
