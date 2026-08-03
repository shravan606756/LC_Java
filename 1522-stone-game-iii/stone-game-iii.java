class Solution {
    int[] dp;

    public String stoneGameIII(int[] stoneValue) {
        dp = new int[stoneValue.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int diff = dfs(stoneValue, 0);

        if (diff > 0) return "Alice";
        if (diff < 0) return "Bob";
        return "Tie";
    }

    public int dfs(int[] arr, int i) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int n = arr.length;

        int result = arr[i] - dfs(arr, i + 1);

        if (i + 1 < n) {
            result = Math.max(result,
                    arr[i] + arr[i + 1] - dfs(arr, i + 2));
        }

        if (i + 2 < n) {
            result = Math.max(result,
                    arr[i] + arr[i + 1] + arr[i + 2] - dfs(arr, i + 3));
        }

        return dp[i] = result;
    }
}