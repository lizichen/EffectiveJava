package LinkedList;

public class ReverseSinglyLinkedList {

    public static ListNode reverseSinglyLinkedList(ListNode head){

        if(head == null)
            return head;

        ListNode todoHead = head.getNext();
        ListNode newHead = head;
        newHead.setNext(null);

        while(todoHead!=null){
            ListNode temp = todoHead;
            todoHead = temp.getNext();
            temp.setNext(newHead);
            newHead = temp;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head!=null){
            ListNode current = head;
            ListNode temp = head.next;
            head.next = newHead;
            newHead = current;
            head = temp;
        }
        return newHead;
    }

    // TODO: Recursive is tricky
    public static ListNode reverseSinglyLinkedList_recursive(ListNode head){
        if(head == null)
            return null;
        if(head.getNext() == null)
            return head;
        else{
            ListNode returnHead = reverseSinglyLinkedList_recursive(head.getNext());
            head.next.next = head;
            head.next = null;
            return returnHead;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.setNext(n2); n2.setNext(n3); n3.setNext(n4);n4.setNext(null);
        ListNode newHead = reverseSinglyLinkedList_recursive(n1);
        ListNode cursor = newHead;
        while(cursor!=null){
            System.out.println(cursor.getValue());
            cursor = cursor.getNext();
        }
    }
}
