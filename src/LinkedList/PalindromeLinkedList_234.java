package LinkedList;

public class PalindromeLinkedList_234 {

    public static boolean isPalindrome(ListNode head) {
        if(head == null) return false;

        // find the middle
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }else{
                break;
            }
        }

        // now the slow pointer is the middle node, reverse!
        // if there is a middle node, the slow pointer points to it.
        ListNode dummy = new ListNode(-1);
        while(slow != fast){
            ListNode tmpNext = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = tmpNext;
        }

        System.out.println("dummy.next value:"+dummy.next.val);

        // now dummy.next is the last node
        // compare with head
        ListNode part2 = dummy.next;
        while(part2.val == head.val){
            System.out.println("head.val:"+head.val+" part2.val:"+part2.val);
            part2 = part2.next;
            head = head.next;
            if(head == null){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode ll = ListNode.buildSinglyLinkedListFromIntArray(new int[]{1,2,2,1});
        System.out.println(isPalindrome(ll));
    }
}
