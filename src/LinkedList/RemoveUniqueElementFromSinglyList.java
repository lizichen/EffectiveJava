package LinkedList;

/**
 * Created by lizichen1 on 9/26/16.
 */
public class RemoveUniqueElementFromSinglyList {

    public static void main(String[] args) {
        SinglyListNode a = buildSinglyLinkedList();
        SinglyListNode b = clean(a);
        while(b !=null){
            System.out.print(" "+b.val);
            b = b.next;
        }
    }

    public static SinglyListNode clean(SinglyListNode a){
        if(a.next == null)
            if (a.val == 0)
                a = null;
            else
                return a;
        else
        if (a.val == 0)
            return clean(a.next);
        else
            a.next = clean(a.next);
        return a;
    }

    public static SinglyListNode buildSinglyLinkedList(){
        int[] arr = {1,2,0,4,0,6,0,8,9,0,10};
        SinglyListNode a = new SinglyListNode(1);

        SinglyListNode cursor = a;

        for(int i=0;i<arr.length;i++){
            SinglyListNode newNode = new SinglyListNode(arr[i]);
            cursor.next = newNode;
            cursor = newNode;
        }

        return a;
    }

}
