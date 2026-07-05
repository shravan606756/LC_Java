class Solution 
{
    int MOD = 1_000_000_007;
    int n;
    int scoreDp[][];
    int pathDp[][];
    
    public int[] pathsWithMaxScore(List<String> board) 
    {
        n = board.size();
        
        scoreDp = new int[n][n];
        pathDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(scoreDp[i], -1);
            Arrays.fill(pathDp[i], -1);
        }

        /*for(int row[] : dp)
        {
            Arrays.fill(row, -1);
        }*/

        int res[] = sol(board, n-1, n-1);
        return res;
    }

    public int[] sol(List<String> board, int i, int j)
    {
        char here = board.get(i).charAt(j);

        if(here == 'E'){
            return new int[]{0,1};
        }

        if(here == 'X')
        {
            return new int[]{0,0};
        }

        if (scoreDp[i][j] != -1) 
        {
            return new int[]{scoreDp[i][j], pathDp[i][j]};
        }

        int upScore=0, upPath=0;
        int leftScore=0, leftPath=0;
        int diagLeftScore=0, diagLeftPath=0;

        //up
        if(isValid(i-1, j, board))
        {
            int r[] = sol(board, i-1, j);
            upScore = r[0];
            upPath = r[1];

            if(upPath>0){
                upScore += getScore(here);
            }
        }

        //left
        if(isValid(i, j-1, board))
        {
            int r[] = sol(board, i, j-1);
            leftScore = r[0];
            leftPath = r[1];

            if(leftPath>0)
            {
                leftScore += getScore(here);
            }
        }

        //diagonal left
        if(isValid(i-1, j-1, board))
        {
            int r[] = sol(board, i-1, j-1);
            diagLeftScore = r[0];
            diagLeftPath = r[1];

            if(diagLeftPath>0)
            {
                diagLeftScore += getScore(here);
            }
        }

        int bestScore = 0;
        int bestPath =0;

        //case 1
        if(upScore==leftScore && leftScore==diagLeftScore)
        {
            bestScore = upScore;
            bestPath = upPath + leftPath + diagLeftPath;
        }

        //case 2
        else if(upScore==leftScore)
        {
            bestScore=upScore;
            bestPath = upPath+leftPath;

            if(diagLeftScore > bestScore || (diagLeftScore==bestScore && diagLeftPath>bestPath))
            {
                bestScore = diagLeftScore;
                bestPath = diagLeftPath;
            }
        }

        //case 3
        else if(upScore==diagLeftScore)
        {
            bestScore = upScore;
            bestPath = upPath + diagLeftPath;

            if(leftScore > bestScore || (leftScore == bestScore && leftPath>bestPath))
            {
                bestScore = leftScore;
                bestPath = leftPath;
            }
        }

        else if(leftScore==diagLeftScore)
        {
            bestScore = leftScore;
            bestPath += leftPath + diagLeftPath;

            if(upScore > bestScore || (upScore == bestScore && upPath>bestPath))
            {
                bestScore = upScore;
                bestPath = upPath; 
            }
        }

        //case 4
        else
        {
            bestScore = upScore;
            bestPath = upPath;

            if(leftScore>bestScore || (leftScore==bestScore && leftPath>bestPath))
            {
                bestScore = leftScore;
                bestPath = leftPath;
            }

            if(diagLeftScore > bestScore || (diagLeftScore == bestScore && diagLeftPath > bestPath))
            {
                bestScore = diagLeftScore;
                bestPath = diagLeftPath;
            }
        }

        bestPath %= MOD;
        scoreDp[i][j] = bestScore;
        pathDp[i][j] = bestPath;

        return new int[] {bestScore, bestPath};
    }

    public boolean isValid(int i, int j, List<String> board)
    {
        return i >= 0 && i < n && j >= 0 && j < n && board.get(i).charAt(j) != 'X';
    }

    public int getScore(char ch)
    {
        return ch =='S' ? 0 : ch-'0';  
    }
}