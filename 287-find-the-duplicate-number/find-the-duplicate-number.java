class Solution {
    public int findDuplicate(int[] arr) 
    {
        int slow = arr[0];
        int fast = arr[0];

        while(true)
        {
            //find cyc's meeting point

            slow = arr[slow];
            fast = arr[arr[fast]];

            if(slow==fast)
            {
                break;
            }
        }

        slow = arr[0];

        while(slow!=fast)
        {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}