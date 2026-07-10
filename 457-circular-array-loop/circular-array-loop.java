class Solution {
    public boolean circularArrayLoop(int[] arr) 
    {
        for(int i=0 ; i<arr.length ; i++)
        {
            int slow=i;
            int fast = i;

            int currDir = 0;

            if(arr[i]>0) currDir = 1;
            else currDir = -1;

            while(true)
            {
                slow = getNext(arr, slow, currDir, arr.length);
                fast = getNext(arr, fast, currDir, arr.length);

                if(fast!=-1){
                    fast = getNext(arr, fast, currDir, arr.length);
                }if(slow==-1 || fast==-1){
                    break;
                }if(fast==slow){
                    return true;
                }
            }
        }

        return false;
    }

    public int getNext(int arr[],int currIdx, int currDir, int n)
    {
        int nextIdx = (currIdx + arr[currIdx]) %n;
        int nextDir = 0;
        if(nextIdx<0){
            nextIdx= (nextIdx+n)%n;
        }

        if(arr[nextIdx]>0) nextDir = 1;
        else nextDir = -1;

        if(currDir!=nextDir || currIdx==nextIdx){
            return -1;
        }

        return nextIdx;
    }
}