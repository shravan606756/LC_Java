class Pair
{
    int n = 0 , m = 0;

    Pair(int n , int m)
    {
        this.n = n;
        this.m = m;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};

        int fresh=0 , time=0;
        Queue <Pair> q = new LinkedList<>();
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new Pair(i,j));
                    grid[i][j] = -2;
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh>0)
        {
            int size = q.size();

            while(size>0)
            {
                Pair z = q.peek();
                q.poll();

                int r = z.n;
                int c = z.m;

                for(int k=0 ; k<4 ; k++)
                {
                    int row = r+x[k];
                    int col = c+y[k];

                    if(isValid(row , col , n , m) && grid[row][col]==1)
                    {
                        q.offer(new Pair(row,col));
                        grid[row][col]=-2;
                        fresh--;
                    }
                }

                size--;
            }

            time++;
        }

        if(fresh>0) return -1;

        return time;
    }

    public static boolean isValid(int i, int j, int n, int m)
    {
        if(i<0 || i>=n || j<0 || j>=m)
        {
            return false;
        }
        
        return true;
    }
}