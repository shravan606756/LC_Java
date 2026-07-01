class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();

        int[][] score = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, Integer.MAX_VALUE);

        bfs(grid, score);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int[][] best = new int[n][n];

        pq.offer(new int[]{0, 0, score[0][0]});
        best[0][0] = score[0][0];

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int x = curr[0];
            int y = curr[1];
            int safe = curr[2];

            if (x == n - 1 && y == n - 1)
                return safe;

            if (safe < best[x][y])
                continue;

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (!isValid(nx, ny, n, n))
                    continue;

                int newSafe = Math.min(safe, score[nx][ny]);

                if (newSafe > best[nx][ny]) {
                    best[nx][ny] = newSafe;
                    pq.offer(new int[]{nx, ny, newSafe});
                }
            }
        }

        return 0;
    }

    private void bfs(List<List<Integer>> grid, int[][] score) {

        int n = grid.size();

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (!isValid(nx, ny, n, n))
                    continue;

                if (score[nx][ny] > score[x][y] + 1) {

                    score[nx][ny] = score[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}