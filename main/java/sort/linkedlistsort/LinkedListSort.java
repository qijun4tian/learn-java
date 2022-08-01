package sort.linkedlistsort;

/**
 * @author qijun
 * @date 2020/7/28 17:14
 */
public class LinkedListSort {

    public ListNode sortList(ListNode head) {
        quickSort(head,null);
        return head;
    }

    public void quickSort(ListNode head,ListNode tail){
        if(head != tail &&  head.next != null){
            ListNode middle = partition(head,tail);
            if(middle == null){
                quickSort(head.next, tail);
            }else {
                quickSort(head, middle);
                if (middle.next != null && middle.next.next != null) {
                    quickSort(middle.next.next, tail);
                }
            }
        }
    }

    public ListNode partition(ListNode head,ListNode tail){
        ListNode beginNode = head;
        ListNode beginNode1 = null;
        int key = head.val;
        ListNode listNode = head.next;
        while (listNode != null){
            if(listNode.val < key){
                beginNode1 = beginNode;
                beginNode = beginNode.next;
                int temp = beginNode.val;
                beginNode.val = listNode.val;
                listNode.val = temp;
            }
            if(listNode == tail){
                break;
            }
            listNode = listNode.next;

        }

        int temp = beginNode.val;
        beginNode.val = key;
        head.val = temp;
        return beginNode1;

    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode3;
        listNode3.next = listNode2;
        listNode2.next = null;

        for(ListNode listNode = listNode1; listNode != null;listNode = listNode.next){
            System.out.println(listNode.val);
        }
        LinkedListSort linkedListSort = new LinkedListSort();
        ListNode listNode = linkedListSort.sortList(listNode1);
        for(ListNode node = listNode; node != null;node = node.next){
            System.out.println(node.val);
        }

    }

}
