class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0 ; i<=n ; i++)
        {
            adj.add(new ArrayList<int[]>());
        }

        for(int edge[] : times)
        {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v,w});
        }

        int ans = Integer.MIN_VALUE;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int dis [] = new int[n+1];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k]=0;
        minHeap.offer(new int[]{0,k});

        while(!minHeap.isEmpty())
        {
            int [] temp = minHeap.poll();

            int node = temp[1];
            int d = temp[0];

            if(d > dis[node])
            {
                continue;
            }

            for(int x[] :adj.get(node))
            {
                int neigh = x[0];
                int wt = x[1];

                if(wt + d < dis[neigh])
                {
                    dis[neigh] = d + wt;
                    minHeap.offer(new int[] {dis[neigh], neigh});
                }
            }
        }

        for(int i=1 ; i<dis.length ; i++)
        {
            ans = Math.max(ans , dis[i]);
        }

        if(ans == Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
}