package LinkedList;

/**
 * Input:
 *  1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output:
 *  1 -> 5 -> 2 -> 4 -> 3 -> null
 */
public class ReverseSinglyLinkedList_2 {

    // find middle node
    public static SinglyListNode findMiddleNode(SinglyListNode head){
        SinglyListNode fast = head.next;
        SinglyListNode slow = head;

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
        SinglyListNode head = new SinglyListNode(1);
        SinglyListNode n2 = new SinglyListNode(2);
        SinglyListNode n3 = new SinglyListNode(3);
        SinglyListNode n4 = new SinglyListNode(4);
        SinglyListNode n5 = new SinglyListNode(5);
        head.setNext(n2); n2.setNext(n3); n3.setNext(n4);n4.setNext(n5);n5.setNext(null);

        SinglyListNode middleNode = findMiddleNode(head);
        System.out.println(middleNode.val);

    }
}
