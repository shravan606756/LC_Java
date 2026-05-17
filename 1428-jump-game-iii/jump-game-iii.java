class Solution {
    public boolean canReach(int[] arr, int start) 
    {
        int n=arr.length;
        
        boolean res = dfs(arr , start , n);
        return res;
    }

    public boolean dfs(int arr[] , int i , int n)
    {
        if(i<0 || i>=n || arr[i]<0)
        {
            return false;
        }

        if(arr[i]==0)
        {
            return true;
        }

        int jump = arr[i];
        arr[i]*=-1;
        boolean plus = dfs(arr , i+jump , n);
        boolean minus = dfs(arr , i-jump , n);

        return plus||minus;
    }
}