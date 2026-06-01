class Solution {

    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            dfs(heights,i,0,pac,n,m);
            dfs(heights,i,m-1,atl,n,m);
        }

        for(int j=0;j<m;j++)
        {
            dfs(heights,0,j,pac,n,m);
            dfs(heights,n-1,j,atl,n,m);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(pac[i][j] && atl[i][j])
                {
                    ans.add(Arrays.asList(i,j));
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] h,int i,int j,boolean[][] visit,int n,int m)
    {
        if(visit[i][j])
            return;

        visit[i][j] = true;

        for(int k=0;k<4;k++)
        {
            int r = i + x[k];
            int c = j + y[k];

            if(isValid(r,c,n,m) &&
               !visit[r][c] &&
               h[r][c] >= h[i][j])
            {
                dfs(h,r,c,visit,n,m);
            }
        }
    }

    public boolean isValid(int i,int j,int n,int m)
    {
        return i>=0 && i<n && j>=0 && j<m;
    }
}