class Solution 
{
    static int[][][] dp = new int[500][500][3];

    static int f(int i, int j, int k, int[][] coins)
    {
        if (i == 0 && j == 0)
        {
            if (k > 0) return Math.max(0, coins[0][0]);
            return coins[0][0];
        }

        if (i < 0 || j < 0 || k < 0) return (int)-1e9;

        if (dp[i][j][k] != Integer.MIN_VALUE) return dp[i][j][k];

        int x = coins[i][j];

        int ans = x + Math.max(f(i-1, j, k, coins), f(i, j-1, k, coins));

        if (x < 0 && k > 0) 
        {
            ans = Math.max(ans, Math.max(
                f(i-1, j, k-1, coins),
                f(i, j-1, k-1, coins)
            ));
        }

        return dp[i][j][k] = ans;
    }

    public int maximumAmount(int[][] coins) 
    {
        int r = coins.length, c = coins[0].length;

        for(int i=0;i<500;i++)
        {
            for(int j=0;j<500;j++)
            {
                for(int k=0;k<3;k++)
                {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return f(r-1, c-1, 2, coins);
    }
}