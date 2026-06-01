class Solution {
    public int maxAreaOfIsland(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int max = Integer.MIN_VALUE;

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};

        boolean visit[][] = new boolean[n][m];
        int area=0;

        for(int i=0 ; i <n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                if(grid[i][j]==1 && visit[i][j]==false)
                {
                    area=dfs(grid, x, y, visit, i, j, n, m);
                    max = Math.max(max,area);
                }
            }
        } 

        if(max==Integer.MIN_VALUE)
        {
            return 0;
        }

        return max;
    }

    public int dfs(int grid[][], int x[], int y[], boolean visit[][], int i, int j, int n, int m)
    {
        visit[i][j]=true;
        int count=1;

        for(int k=0 ; k<4 ; k++)
        {
            int row = i+x[k];
            int col = j+y[k];

            if(isValid(row, col, n, m) && grid[row][col]==1 && visit[row][col]==false)
            {
                count+=dfs(grid, x, y, visit, row, col, n, m);
            }
        }

        return count;
    }

    public boolean isValid(int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return false;
        }
        return true;
    }
}