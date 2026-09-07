class Solution {
    static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int n = s.length();

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int res = solve(s, prev, n - 1, dp);

        return (res - 1 + MOD) % MOD;
    }

    public int solve(String s, int[] prev, int idx, int[] dp) {

        if (idx < 0) {
            return 1;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        long sol = (2L * solve(s, prev, idx - 1, dp)) % MOD;

        if (prev[idx] != -1) {
            long dup = solve(s, prev, prev[idx] - 1, dp);

            sol = (sol - dup + MOD) % MOD;
        }

        return dp[idx] = (int) sol;
    }
}