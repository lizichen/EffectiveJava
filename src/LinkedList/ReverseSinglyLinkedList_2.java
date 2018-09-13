package LinkedList;

/**
 * Input:
 *  1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output:
 *  1 -> 5 -> 2 -> 4 -> 3 -> null
 */
public class ReverseSinglyLinkedList_2 {

    // find middle node
    public static ListNode findMiddleNode(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    // reverse the second half

    // create a dummy node for the new head

    // merge from two heads


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.setNext(n2); n2.setNext(n3); n3.setNext(n4);n4.setNext(n5);n5.setNext(null);

        ListNode middleNode = findMiddleNode(head);
        System.out.println(middleNode.val);

    }
}
