class Solution {
    public boolean circularArrayLoop(int[] arr) 
    {
        int n = arr.length;

        for(int i=0 ; i<n ; i++)
        {
            int slow = i;
            int fast = i;
            int currDir = 1;
            
            if(arr[i]>0){
                currDir = 1;
            }else{
                currDir = -1;
            }

            while(true)
            {
                slow = getNext(arr, currDir, slow, n);
                fast = getNext(arr, currDir, fast, n);

                if(fast!=-1)
                {
                    fast = getNext(arr, currDir, fast, n);
                }

                if(slow==-1 || fast==-1)
                {
                    break;
                }

                if(slow==fast){
                    return true;
                }
            }
        }

        return false;
    }

    public int getNext(int arr[], int currDir, int currIdx, int n)
    {
        int nextIdx = (currIdx + arr[currIdx]) % n;
        if(nextIdx<0)
        {
            nextIdx = (nextIdx + n)%n; 
        }

        int nextDir = 0;
        if(arr[nextIdx]>0){
            nextDir = 1;
        }else{
            nextDir = -1;
        }

        if(currDir!=nextDir || currIdx==nextIdx){
            return -1;
        }

        return nextIdx;
    }
}