class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int d = road[2];

            adj.get(u).add(new int[]{v, d});
            adj.get(v).add(new int[]{u, d});
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int dist = edge[1];

                ans = Math.min(ans, dist);

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }

        return ans;
    }
}