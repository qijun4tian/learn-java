package java.链表;

/**
 * @Author:qijun
 * @Description
 * @Date 11:46 2021/11/28
 */
public class 删除链表中的节点 {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
        next.next = null;

    }
}
