/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode meetingNode = isCycle(head);
        if(meetingNode==null){
            return null; 
        }

        ListNode slow = head;
        ListNode fast = meetingNode;

        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode isCycle(ListNode head)
    {
        if(head==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) break;
        }
        if(slow==null || slow.next==null || fast==null || fast.next==null) return null;

        return slow;
    }
}