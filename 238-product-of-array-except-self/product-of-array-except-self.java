class Solution {
    public int[] productExceptSelf(int[] arr) 
    {
        int res[] = new int [arr.length];

        res[0]=1;

        for(int i=1 ; i<arr.length ; i++)
        {
            res[i] = res[i-1]*arr[i-1];
        }
        
        int post=1;
        for(int i=arr.length-1 ; i>=0 ; i--)
        {
            res[i] *= post;
            post *= arr[i];
        }

        return res;
    }
}