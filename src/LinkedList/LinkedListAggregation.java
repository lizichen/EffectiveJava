package LinkedList;
/**
 * Created by lizichen1 on 9/12/16.
 */
public class LinkedListAggregation {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        sumsInReverse(node1);

        ListNode dummy = node1;

        for(int i=0;i<5;i++){
            System.out.print(dummy.getValue()+" ");
            dummy = dummy.getNext();
        }
    }

    public static int sumsInReverse(ListNode n){
        if(n == null){
            return 0;
        }
        else{
            int value = n.getValue();
            n.setValue(value + sumsInReverse(n.getNext()));
        }
        return n.getValue();
    }

    public static void sums(ListNode n, int sum){
        if (n.getNext() == null){
            int value = n.getValue();
            n.setValue(value + sum);
        }
        else{
            int value = n.getValue();
            n.setValue(value + sum);
            sums(n.getNext(), n.getValue());
        }
    }
}