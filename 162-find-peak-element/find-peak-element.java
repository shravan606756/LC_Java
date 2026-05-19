class Solution {
    public int findPeakElement(int[] arr) 
    {
        int n = arr.length;

        int low = 0 , high = n-1;

        while(low<high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid+1]<arr[mid])
            {
                high=mid;
            }

            else
            {
                low=mid+1;
            }
        }

        return low;
    }
}