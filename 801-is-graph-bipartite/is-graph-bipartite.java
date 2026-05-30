class Solution {
    public boolean isBipartite(int[][] graph) 
    {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        int c=1;
        for(int i=0 ; i<graph.length ; i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(graph, color, i, c)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int [][] graph, int color[], int node, int c)
    {
        color[node]=c;

        for(int i=0 ; i<graph[node].length ; i++)
        {
            int neigh = graph[node][i];

            if(color[neigh]!=-1)
            {
                if(color[neigh]==c){
                return false;
                }
            }

            else{
                if(!dfs(graph, color, neigh, 1-c)) return false;
            }
        }
        return true;
    }
}