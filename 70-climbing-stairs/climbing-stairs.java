class Solution {
    public int climbStairs(int n) 
    {
        int idx=0;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return dfs(n, dp, 0);
    }

    public int dfs(int n, int dp[], int idx)
    {
        if(idx==n)
        {
            return 1;
        }

        if(idx>n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }

        int a = dfs(n, dp, idx+1);
        int b = dfs(n, dp, idx+2);

        int res = a+b;
        dp[idx]=res;

        return res;
    }
}