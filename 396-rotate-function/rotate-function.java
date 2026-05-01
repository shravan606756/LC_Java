class Solution {
    public int maxRotateFunction(int[] arr) 
    {
        int n = arr.length;
        int f=0;
        int cum=0;

        for(int i=0 ; i<n ; i++)
        {
            cum += arr[i];
            f += i*arr[i];
        }   
        int max = f;
        for(int k=1 ; k<n ; k++)
        {
            f = f+cum-n*arr[n-k];
            max = Math.max(max , f);
        }
        return max; 
    }
}