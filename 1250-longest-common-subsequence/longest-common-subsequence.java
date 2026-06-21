class Solution {
    public int longestCommonSubsequence(String text1, String text2) 
    {
        int dp[][] = new int [1001][1001];

        for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }

        int res = dfs(text1, text2, dp, 0, 0);
        return res;
    }

    public int dfs(String s1, String s2, int dp[][], int i, int j)
    {
        if(i>=s1.length() || j>=s2.length())
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j] = 1+dfs(s1, s2, dp, i+1, j+1);
        }

        int a = dfs(s1, s2, dp, i+1, j);
        int b = dfs(s1, s2, dp, i, j+1);

        return dp[i][j]=Math.max(a,b);
    }
}