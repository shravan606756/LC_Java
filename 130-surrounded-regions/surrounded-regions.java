class Solution {
    public void solve(char[][] board) 
    {
        int n = board.length;
        int m = board[0].length;

        int x[] = {1,-1,0,0};
        int y[] = {0,0,-1,1};

        for(int j=0 ; j<m ; j++)//first row
        {
            if(board[0][j]=='O')
            {
                dfs(board, x, y, n, m, 0, j);
            }
        }

        for(int j=0 ; j<m ; j++)//last row
        {
            if(board[n-1][j]=='O')
            {
                dfs(board, x, y, n, m, n-1, j);
            }
        }

        for(int i=0 ; i<n ; i++)//forst col
        {
            if(board[i][0]=='O')
            {
                dfs(board, x, y, n, m, i, 0);
            }
        }

        for(int i=0 ; i<n ; i++)//last col
        {
            if(board[i][m-1]=='O')
            {
                dfs(board, x, y, n, m, i, m-1);
            }
        }

        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
                if(board[i][j]=='#')
                {
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char [][] board, int x[], int y[], int n, int m, int i, int j)
    {
        board[i][j]='#';

        for(int k=0 ; k<4 ; k++)
        {
            int row=i+x[k];
            int col=j+y[k];

            if(isValid(row, col, n, m) && board[row][col]=='O')
            {
                dfs(board, x, y, n, m, row, col);
            }
        }
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