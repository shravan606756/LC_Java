class Solution {
    public int maximumSum(int[] arr) 
    {
        int n = arr.length;
        int noDelete = arr[0];
        int oneDelete = 0;
        int ans = Integer.MIN_VALUE;

        for(int i=1 ; i<n ; i++)
        {
            int prevNoDelete = noDelete;
            int prevOneDelete = oneDelete;

            noDelete = Math.max(prevNoDelete+arr[i], arr[i]);
            
            oneDelete = Math.max(prevNoDelete, prevOneDelete+arr[i]);

            ans = Math.max(ans, Math.max(noDelete, oneDelete));
        }

        return ans==Integer.MIN_VALUE ? arr[0] : ans;        
    }
}