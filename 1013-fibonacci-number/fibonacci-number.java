class Solution 
{
    public int fib(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = sol(n, dp);
        return ans;
    }
    public int sol(int n, int dp[]) 
    {
        
        if(n==0 || n==1){
            return n;
        }    

        if(dp[n]!=-1){
            return dp[n];
        }

        int a1 = sol(n-1, dp);
        int a2 = sol(n-2, dp);

        int res = a1+a2;
        dp[n]=res;

        return res;
    }
}