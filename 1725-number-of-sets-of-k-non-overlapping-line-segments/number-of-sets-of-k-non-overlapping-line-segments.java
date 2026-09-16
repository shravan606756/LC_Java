class Solution {
    int MOD = 1_000_000_007;
    int[][] dp;
    int[][] sum;

    public int numberOfSets(int n, int k) {
        dp = new int [1001][1001];
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }

        sum = new int[1001][1001];
        for(int rows[] : sum){
            Arrays.fill(rows, -1);
        }

        int res = (solve(n, k, 0)) % MOD;

        return res%MOD;
    }

    public int solve(int n, int k, int idx){
        if(k==0){
            return 1;
        }

        if(idx>=n){
            return 0;
        }

        if(dp[k][idx]!=-1){
            return dp[k][idx];
        }

        int skip = solve(n, k, idx+1);
        int take=0;

        /*for(int j=idx+1; j<n; j++){
            take = (take + solve(n, k-1, j))%MOD;
        }*/

        if(idx+1<n){
            take = suffix(n, k-1, idx+1);
        }

        return dp[k][idx] = (int) (skip+take)%MOD;
    }

    public int suffix(int n, int k, int idx){
        if(idx >= n){
            return 0;
        }

        if(sum[k][idx] != -1){
            return sum[k][idx];
        }
        int ans = solve(n, k, idx);

        ans = (ans + suffix(n, k, idx + 1)) % MOD;

        return sum[k][idx] = ans;
    }
}