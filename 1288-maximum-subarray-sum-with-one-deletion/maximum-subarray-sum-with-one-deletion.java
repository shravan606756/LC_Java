class Solution {
    public int maximumSum(int[] arr) 
    {
        int n = arr.length;
        int oneDelete = 0;
        int noDelete = arr[0];
        int max = arr[0];

        for(int i=1 ; i<n ; i++)
        {
            oneDelete = Math.max(arr[i]+oneDelete, noDelete);
            noDelete = Math.max(arr[i], arr[i]+noDelete);
            max = Math.max(max, Math.max(noDelete, oneDelete));
        }    

        return max;
    }
}