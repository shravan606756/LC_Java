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
    public ListNode deleteMiddle(ListNode head) 
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        int n = getSize(head);
        int mid = n/2;
        ListNode temp=head;

        for(int i=0 ; i<mid-1 ; i++)
        {
            temp=temp.next;
        }     

        temp.next = temp.next.next;
        return head;
    }

    public int getSize(ListNode head)
    {
        if(head==null){
            return 0;
        }

        int size=0;

        while(head!=null)
        {
            size++;
            head=head.next;
        }

        return size;
    }
}