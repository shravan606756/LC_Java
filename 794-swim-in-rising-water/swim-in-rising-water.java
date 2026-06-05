class Solution {
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        int max = grid[0][0];

        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                max = Math.max(max, grid[i][j]);
            }
        }    

        int low=grid[0][0], high = max;
        int res=0;

        while(low<=high)
        {
            int guess = low + (high-low) / 2;

            if(bfs(grid , guess, n, m))
            {
                res=guess;
                high = guess-1;
            }
            else{
                low = guess+1;
            }
        }

        return res;
    }

    public boolean bfs(int grid[][], int guess, int n, int m)
    {
        Queue<int []> q = new LinkedList<>();
        boolean visit[][] = new boolean[n][m];

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};

        q.offer(new int[]{0,0});
        visit[0][0]=true;

        while(!q.isEmpty())
        {
            int temp[] = q.peek();
            q.poll();

            int i = temp[0];
            int j = temp[1];

            if(i==n-1 && j==m-1)
            {
                return true;
            }

            for(int k=0 ; k<4 ; k++)
            {
                int row = i+x[k];
                int col = j+y[k];

                if(isValid(row, col, n, m) && visit[row][col]==false && guess>=grid[row][col])
                {
                    q.offer(new int[]{row, col});
                    visit[row][col]=true;
                }
            }
        }

        return false;
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