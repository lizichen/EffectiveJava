package LinkedList;

import LinkedList.SinglyListNode;

/**
 * Created by lizichen1 on 10/31/16.
 */
public class ReverseSinglyLinkedList {

    public static SinglyListNode reverseSinglyLinkedList(SinglyListNode head){

        if(head == null)
            return head;

        SinglyListNode todoHead = head.getNext();
        SinglyListNode newHead = head;
        newHead.setNext(null);

        while(todoHead!=null){
            SinglyListNode temp = todoHead;
            todoHead = temp.getNext();
            temp.setNext(newHead);
            newHead = temp;
        }
        return newHead;
    }

    // TODO: Recursive is tricky
    public static SinglyListNode reverseSinglyLinkedList_recursive(SinglyListNode head){
        if(head == null)
            return null;
        if(head.getNext() == null)
            return head;
        else{
            SinglyListNode returnHead = reverseSinglyLinkedList_recursive(head.getNext());
            head.next.next = head;
            head.next = null;
            return returnHead;
        }
    }

    public static void main(String[] args) {
        SinglyListNode n1 = new SinglyListNode(1);
        SinglyListNode n2 = new SinglyListNode(2);
        SinglyListNode n3 = new SinglyListNode(3);
        SinglyListNode n4 = new SinglyListNode(4);
        n1.setNext(n2); n2.setNext(n3); n3.setNext(n4);n4.setNext(null);
        SinglyListNode newHead = reverseSinglyLinkedList_recursive(n1);
        SinglyListNode cursor = newHead;
        while(cursor!=null){
            System.out.println(cursor.getValue());
            cursor = cursor.getNext();
        }
    }
}
