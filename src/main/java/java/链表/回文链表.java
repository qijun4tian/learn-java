package java.链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xnv1oc/
 * @Author:qijun
 * @Description
 * @Date 22:38 2021/11/26
 */
public class 回文链表 {

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode tmp = head;
        int legth = 0;
        while (tmp != null){
            legth ++;
            tmp = tmp.next;
        }
        int half = legth /2;
        int begin = 0;
        ListNode tmp1 = head;
        Deque<ListNode> deque = new LinkedList<>();
        while (begin < half){
            deque.push(tmp1);
            tmp1 = tmp1.next;
            begin ++;
        }
        if(legth % 2 != 0){
            tmp1 = tmp1.next;
        }
        while (tmp1!= null && deque.size() != 0){
            if(tmp1.val != deque.pop().val){
                return false;
            }
            tmp1 = tmp1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        isPalindrome(listNode);


    }

}
