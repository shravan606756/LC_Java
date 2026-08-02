class Solution {
    static int dp[][];

    public boolean stoneGame(int[] piles) 
    {
        int n = piles.length;
        dp = new int[n+1][n+1];

        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }

        int total = 0;

        for(int x : piles){
            total +=x;
        }

        int Alice = dfs(piles, 0, n-1);
        int bob = total - Alice;

        return Alice >= bob;
    }

    public int dfs(int arr[], int i, int j)
    {
        if(i>j){
            return 0;
        }if(i==j){
            return arr[i];
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int c1 = arr[i] + Math.min(dfs(arr, i+2, j), dfs(arr, i+1, j-1));
        int c2 = arr[j] + Math.min(dfs(arr, i+1, j-1), dfs(arr, i, j-2));

        return dp[i][j] = Math.max(c1, c2);
    }
}