package LinkedList;

public class LinkedListCycle_142 {
    public static SinglyListNode detectCycle(SinglyListNode head) {
        if(head == null || head.next == null)
            return null;

        SinglyListNode walker = head.next;
        SinglyListNode runner = head.next;
        if(runner != null)
            runner = runner.next;
        else
            return null;

        while(runner != null){
            if(walker == runner){

                while (head != walker) {
                    head = head.next;
                    walker = walker.next;
                }
                return walker;

            }else{
                walker = walker.next;
                runner = runner.next;
                if(runner != null)
                    runner = runner.next;
                else
                    return null;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3};
        SinglyListNode root = SinglyListNode.buildSinglyLinkedListFromIntArray(arr);
        root.next.next.next.next = root.next;
        detectCycle(root);
    }

}
