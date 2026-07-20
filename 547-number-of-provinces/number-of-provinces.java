class Solution {
    public int findCircleNum(int[][] isNigger) 
    {
        //find total no. of nigger towns

        int n = isNigger.length;
        boolean visit[]= new boolean[n];
        int c=0;

        for(int i=0 ; i<n ; i++)
        {
            if(visit[i]==false)
            {
                dfs(isNigger, visit, i);
                c++;
            }
        }

        return c;
    }

    public void dfs(int grid[][], boolean visit[], int node)
    {
        visit[node] = true;

        for(int i=0 ; i<grid.length ; i++)
        {
            if(visit[i]==false && grid[node][i]==1)
            {
                dfs(grid, visit, i);
            }
        }
    }
}