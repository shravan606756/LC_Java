class Solution {
    public int countCompleteComponents(int n, int[][] edges) 
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0 ; i<edges.length ; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visit[] = new boolean[n];
        int ans=0;
        for(int i=0 ; i<n ; i++)
        {
            if(visit[i]) continue;

            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            visit[i]=true;

            int nodes=0;
            int edgeCount=0;

            while(!q.isEmpty()){
                int u  = q.poll();
                nodes++;
                edgeCount += adj.get(u).size();

                for(int v : adj.get(u)){
                    if(!visit[v]){
                        visit[v] = true;
                        q.offer(v);
                    }
                }
            }

            edgeCount = edgeCount/2;

            if(edgeCount == nodes*(nodes-1)/2){
                ans++;
            }
        }

        return ans;
    }
}