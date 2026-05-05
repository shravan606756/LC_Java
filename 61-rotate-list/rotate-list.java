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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;

        //find last node
        ListNode left = head;
        int n = 1;
        while(left.next!=null)
        {
            left = left.next;
            n++;
        }

        k = k%n;//handels larger value of k

        left.next = head; //making it circular

        ListNode t = head;
        for(int i=1 ; i<n-k ; i++)
        {
            t = t.next;
        }

        ListNode res = t.next; // making n-k-1th node as new head to be returned
        t.next=null; //disconnecting n-kth node i.e now n-kth node is now new last node

        return res;
    }
}