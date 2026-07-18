class Solution {
    public int findDuplicate(int[] arr) 
    {
        //simulating as a linkedlist

        int slow = arr[0]; //head
        int head = arr[0];

        while(true)
        {
            slow = arr[slow];
            head = arr[arr[head]];

            if(slow==head) break;
        }

        slow = arr[0];

        while(slow!=head)
        {
            slow = arr[slow];
            head = arr[head];
        }

        return slow;
    }
}