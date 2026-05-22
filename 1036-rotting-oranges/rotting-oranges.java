class pair
{
    int n1=0 , n2=0;

    public pair(int n1 , int n2)
    {
        this.n1 = n1;
        this.n2 = n2;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;
        int fresh=0 , time=0;

        int x[] = {1,-1,0,0};
        int y[] = {0,0,-1,1};

        Queue<pair> q = new LinkedList<>();
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new pair(i,j));
                    grid[i][j] = -2; 
                }                

                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0)
        {
            int size = q.size();

            while(size>0)
            {
                pair p = q.peek();
                q.poll();

                int r = p.n1;
                int c = p.n2;

                for(int k=0 ; k<4 ; k++)
                {
                    int row = r + x[k];
                    int col = c + y[k];
                    if( isValid(row , col , n ,m) && grid[row][col]==1)
                    {
                        q.offer(new pair(row , col));
                        grid[row][col] = -2;
                        fresh--;
                    }
                }   
                size--;
            }
            time++;
        }

        if(fresh>0)
        {
            return -1;
        }

        return time;
    }

    public boolean isValid(int i , int j ,int n , int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return false;
        }

        return true;
    }
}