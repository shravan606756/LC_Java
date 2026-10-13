class Solution {
    public int[] productExceptSelf(int[] arr) 
    {
        int n = arr.length;
        int pre[] = new int [n];

        pre[0]=1;

        for(int i=1 ; i<n ; i++){
            pre[i] = pre[i-1]*arr[i-1];
        }   

        int suff[] = new int[n];
        suff[n-1]=1;

        for(int i=n-2 ; i>=0 ; i--)
        {
            suff[i] = suff[i+1]*arr[i+1];
        }

        int res[]=new int[n];
        for(int i=0 ; i<n ; i++)
        {
            res[i] = suff[i]*pre[i];
        }

        return res;
    }
}