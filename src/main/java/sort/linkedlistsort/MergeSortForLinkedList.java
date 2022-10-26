package sort.linkedlistsort;

public class MergeSortForLinkedList {


    public ListNode sortList(ListNode head) {
        ListNode tempNode = new ListNode(Integer.MIN_VALUE);
        tempNode.next = head;
        if(head == null){
            return head;
        }
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        for(int i =1 ; i < length ;i = i*2){
            ListNode cur = tempNode.next;
            ListNode tail =tempNode;
            while (cur != null){
                ListNode left = cur;
                ListNode right = cut(cur,i);
                cur = cut(right,i);
                tail.next = merge(left,right);
                while (tail.next != null){
                    tail = tail.next;
                }
            }
        }


        return tempNode.next;
    }


    public ListNode merge(ListNode head1, ListNode head2){
        ListNode tempHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = tempHead;
        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                p.next = head1;
                p = p.next;
                head1 = head1.next;
            }else {
                p.next = head2;
                head2 = head2.next;
                p = p.next;
            }
        }
        if(head1 == null){
            p.next = head2;
        }else {
            p.next = head1;
        }
        return tempHead.next;

    }


    public ListNode cut(ListNode head, int size){
        if(size == 0){
            return head;
        }
        ListNode p = head;
        while (--size > 0 && p !=null){
            p = p.next;
        }
        if(p == null){
            return null;
        }
        ListNode temp = p.next;
        p.next = null;
        return temp;
    }

}
