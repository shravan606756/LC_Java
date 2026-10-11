class Solution {
    public int sumOfSquares(int[] arr)
    {
        int n = arr.length;

        int res=0;
        for(int i=1 ; i<=n ; i++)
        {   
            if(n%i==0){
                res+=arr[i-1]*arr[i-1];
            }
        }    

        return res;
    }
}