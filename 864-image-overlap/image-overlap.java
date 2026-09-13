class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int max=0;

        for(int i=-n+1 ; i<n ; i++)
        {
            for(int j=-n+1 ; j<n ; j++)
            {
                int count = countOverlaps(img1, img2, i, j);
                max = Math.max(max, count);
            }
        }

        return max;
    }

    public int countOverlaps(int img1[][], int img2[][], int rowOffSet, int colOffSet)
    {
        int row = img1.length;
        int col = img1[0].length;
        int currCount=0;

        for(int i=0 ; i<row ; i++)
        {
            for(int j=0 ; j<col ; j++)
            {
                int x1 = rowOffSet + i;
                int x2 = colOffSet + j;

                if(x1<0 || x1>=row || x2<0 || x2>=col){
                    continue;
                }

                if(img1[i][j]==1 && img2[x1][x2]==1){
                    currCount++;
                }
            }
        }

        return currCount;
    }
}