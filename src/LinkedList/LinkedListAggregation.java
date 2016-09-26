package LinkedList;
/**
 * Created by lizichen1 on 9/12/16.
 */
public class LinkedListAggregation {
    public static void main(String[] args) {

        SinglyListNode node1 = new SinglyListNode(3);
        SinglyListNode node2 = new SinglyListNode(4);
        SinglyListNode node3 = new SinglyListNode(5);
        SinglyListNode node4 = new SinglyListNode(6);
        SinglyListNode node5 = new SinglyListNode(7);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        sumsInReverse(node1);

        SinglyListNode dummy = node1;

        for(int i=0;i<5;i++){
            System.out.print(dummy.getValue()+" ");
            dummy = dummy.getNext();
        }
    }

    public static int sumsInReverse(SinglyListNode n){
        if(n == null){
            return 0;
        }
        else{
            int value = n.getValue();
            n.setValue(value + sumsInReverse(n.getNext()));
        }
        return n.getValue();
    }

    public static void sums(SinglyListNode n, int sum){
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