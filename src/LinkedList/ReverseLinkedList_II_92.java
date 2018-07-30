package LinkedList;


public class ReverseLinkedList_II_92 {


    public static SinglyListNode reverseBetween(SinglyListNode head, int m, int n) {

        // 1 - 2 - 3 - 4 - 5
        // 1 - 2
        //         3 - 4
        //                 5
        // H   T   H   T   H

        SinglyListNode head1 = head;
        SinglyListNode previous = null;
        SinglyListNode tail1 = head;
        SinglyListNode head2 = null;
        SinglyListNode tail2 = null;
        SinglyListNode head3 = null;

        int index = 1;
        while(index <= n){
            if(index < m){
                previous = tail1;
                tail1 = tail1.next;
            }else if(index == m){
                head2 = tail1;
                tail1 = previous;
                tail2 = head2;
            }else{
                tail2 = tail2.next;
            }
            index++;
        }

        head3 = tail2.next;

        // in case m = n
        if(m == n){
            tail2 = head2;
        }

        // now reverse the part between head2 and tail2
        SinglyListNode newHead2 = head2;

        while(head2 != head3){
            SinglyListNode next = head2.next;
            SinglyListNode prev = newHead2;
            newHead2 = head2;
            newHead2.next = prev;
            head2 = next;
        }

        // connect tail1 with newHead2 and head3 with newTail
        tail1.next = newHead2;
        tail2.next = head3;

        return head1;
    }

    public static void main(String[] args){
        SinglyListNode head = new SinglyListNode(1);
        SinglyListNode n2 = new SinglyListNode(2);
        SinglyListNode n3 = new SinglyListNode(3);
        SinglyListNode n4 = new SinglyListNode(4);
        SinglyListNode n5 = new SinglyListNode(5);

        head.setNext(n2); n2.setNext(n3); n3.setNext(n4);n4.setNext(n5);n5.setNext(null);

        SinglyListNode middleNode = reverseBetween(head, 2, 4);
        System.out.println(middleNode.val);

    }
}
