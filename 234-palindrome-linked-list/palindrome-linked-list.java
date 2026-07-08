/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        if(head==null) return true;
        if(head.next==null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }    

        ListNode first = head;
        ListNode second = Reverse(slow);

        while(second != null)
        {
            if(first.val != second.val)
                return false;

            first = first.next;
            second = second.next;
        }

        return true;
    }

    public ListNode Reverse(ListNode head)
    {
        ListNode currNode = head;
        ListNode prev = null;

        while(currNode!=null)
        {
            ListNode temp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = temp;
        }

        head = prev;
        return head;
    }
}