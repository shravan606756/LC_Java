import java.util.*;

class Solution {
    public int[][] minAbsDiff(int[][] g, int k) {
        int m = g.length, n = g[0].length;
        int[][] a = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                int[] t = new int[k * k];
                int x = 0;

                for (int r = i; r < i + k; r++) {
                    for (int c = j; c < j + k; c++) {
                        t[x++] = g[r][c];
                    }
                }

                Arrays.sort(t);

                int min = Integer.MAX_VALUE;
                for (int p = 1; p < t.length; p++) {
                    if (t[p] != t[p - 1]) 
                    {
                        min = Math.min(min, t[p] - t[p - 1]);
                    }
                    if (min == 0) break;
                }

                a[i][j] = min == Integer.MAX_VALUE ? 0 : min;
            }
        }
        return a;
    }
}