class Solution {
    public int minimumEffortPath(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        res[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int dis = p[0];
            int row = p[1];
            int col = p[2];

            if (row == n - 1 && col == m - 1)
                return dis;

            if (dis > res[row][col])
                continue;

            for (int k = 0; k < 4; k++) {
                int r = row + dx[k];
                int c = col + dy[k];

                if (!valid(r, c, n, m))
                    continue;

                int absdiff = Math.abs(a[row][col] - a[r][c]);
                int newwt = Math.max(absdiff, dis);

                if (newwt < res[r][c]) {
                    res[r][c] = newwt;
                    pq.offer(new int[]{newwt, r, c});
                }
            }
        }

        return 0;
    }

    boolean valid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
}