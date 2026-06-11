class Solution {

    long MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {

        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int level = getLevel(adj, 1, n);

        if (level == 0) {
            return 0;
        }

        return (int) power(2, level - 1);
    }

    public int getLevel(List<List<Integer>> adj, int node, int n) {

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];

        q.offer(new int[] { node, 0 });
        vis[node] = true;

        int maxLevel = 0;

        while (!q.isEmpty()) {

            int[] temp = q.poll();

            int curr = temp[0];
            int lvl = temp[1];

            maxLevel = Math.max(maxLevel, lvl);

            for (int j = 0; j < adj.get(curr).size(); j++) {

                int neigh = adj.get(curr).get(j);

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.offer(new int[] { neigh, lvl + 1 });
                }
            }
        }

        return maxLevel;
    }

    public long power(long base, long exp) {

        long res = 1;

        while (exp > 0) {

            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exp = exp / 2;
        }

        return res;
    }
}