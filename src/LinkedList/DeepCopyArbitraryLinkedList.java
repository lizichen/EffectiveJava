package LinkedList;

import java.util.Hashtable;

/**
 * Created by lizichen1 on 10/31/16.
 *
 * a linked list where the node has two pointers: .next and .arbitrary_pointer.
 *
 * Hint: use Hash table
 * Leetcode level: Hard
 */
public class DeepCopyArbitraryLinkedList {

    public static final String CLONED_LIST = "Cloned List:";
    public static final String ORIGINAL_LIST = "Original List:";

    public static void main(String[] args) {
        RandomListNode head = constructSampleArbitraryList();
        printListNodesAndAddress(head, ORIGINAL_LIST);
        RandomListNode clonedHead = deepcopy(head);
        printListNodesAndAddress(clonedHead, CLONED_LIST);
    }

    public static RandomListNode deepcopy(RandomListNode head) {
        if(head == null)
            return null;

        RandomListNode cursor = head;
        RandomListNode newHead = null;
        RandomListNode previous = null;

        Hashtable<RandomListNode, RandomListNode> nodeMap = new Hashtable<>();

        while(cursor!=null){
            RandomListNode newNode = new RandomListNode(cursor.getValue());
            newNode.setNext(cursor.getNext());
            if(newHead==null) {
                newHead = newNode;
                previous = newHead;
            }
            else{
                previous.setNext(newNode);
                previous = newNode;
            }
            nodeMap.put(cursor, newNode);
            cursor = (RandomListNode) cursor.getNext();
        }
        // TODO: review use of hashtable
        cursor = head;
        previous = newHead;
        while(cursor!=null){
            if(cursor.getNextRandomListNode()!=null)
                previous.setNextRandomListNode(nodeMap.get(cursor));
            else
                previous.setNextRandomListNode(null);
            cursor = (RandomListNode) cursor.getNext();
            previous = (RandomListNode) previous.getNext();
        }
        return newHead;
    }

    public static RandomListNode constructSampleArbitraryList() {
        RandomListNode n1 = new RandomListNode(7);
        RandomListNode n2 = new RandomListNode(14);
        RandomListNode n3 = new RandomListNode(21);

        n1.setNext(n2);
        n2.setNext(n3);

        n1.setNextRandomListNode(n3);
        n2.setNextRandomListNode(null);
        n3.setNextRandomListNode(n1);

        return n1;
    }

    public static void printListNodesAndAddress(RandomListNode clonedHead, String nodeName) {
        while(clonedHead!=null){
            System.out.println(nodeName + " value: "+ clonedHead.getValue() + " address: " + clonedHead);
            System.out.println(nodeName + " getNext() address: "+ clonedHead.getNext());
            System.out.println(nodeName + " getNextRandomListNode() address:" + clonedHead.getNextRandomListNode());
            System.out.println();
            clonedHead = (RandomListNode) clonedHead.getNext();
        }
    }
}

class RandomListNode extends ListNode {

    private RandomListNode nextArbitraryNode;

    public RandomListNode(int value) {
        super(value);
    }

    public void setNextRandomListNode(RandomListNode node){
        this.nextArbitraryNode = node;
    }

    public RandomListNode getNextRandomListNode(){
        return this.nextArbitraryNode;
    }
}