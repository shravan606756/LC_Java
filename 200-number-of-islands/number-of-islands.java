class Solution {
    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;

        boolean visit[][] = new boolean[n][m];
        int x[] = {-1,1,0,0};
        int y[] = {0,0,-1,1};

        int count=0;

        for(int i=0 ; i<n ; i++)
        {
            for(int j=0; j<m ; j++)
            {
                if(grid[i][j]=='1' && visit[i][j]==false)
                {
                    dfs(grid, visit, n , m , i, j, x, y);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char [][] grid, boolean visit[][], int n, int m, int i, int j, int x[] , int y[])
    {
        visit[i][j]=true;
        for(int k=0 ; k<4 ; k++)
        {
            int row = i+x[k];
            int col = j+y[k];
            if(valid(row , col , n, m) && grid[row][col]=='1' && visit[row][col]==false)
            {
                dfs(grid, visit, n, m, row, col, x , y);
            }
        }
    }

    public boolean valid(int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return false;
        }
        return true;
    }
}