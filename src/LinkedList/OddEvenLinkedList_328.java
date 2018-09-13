package LinkedList;

public class OddEvenLinkedList_328 {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode oddCursor = head;

        ListNode evenHead = new ListNode(-1);
        ListNode evenCursor = evenHead;

        while(oddCursor != null || evenCursor != null){
            ListNode even = null;
            ListNode odd = null;

            if(oddCursor.next != null){
                even = oddCursor.next;
            }else{
                evenCursor.next = null; // end the list;
                break;
            }

            evenCursor.next = even;
            evenCursor = even;
            if(evenCursor.next != null){
                odd = evenCursor.next;
            }else{
                oddCursor.next = null; // end the list;
                break;
            }

            oddCursor.next = odd;
            oddCursor = odd;
        }

        oddCursor.next = evenHead.next;

        ListNode.printListNode(head);

        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildSinglyLinkedListFromIntArray(new int[]{1,2,3,4,5,6});
        oddEvenList(head);
    }
}
