class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();

        // {cost, r, c}, min-heap ordered by cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] result = new int[m][n];
        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);

        result[0][0] = grid.get(0).get(0); //Source = {0, 0}
        pq.offer(new int[]{result[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], r = top[1], c = top[2];

            if (d > result[r][c]) continue;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                if (d + grid.get(nr).get(nc) < result[nr][nc]) {
                    result[nr][nc] = d + grid.get(nr).get(nc);
                    pq.offer(new int[]{result[nr][nc], nr, nc});
                }
            }
        }

        return health - result[m-1][n-1] >= 1;
    }
}