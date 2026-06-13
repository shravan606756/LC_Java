class TreeAncestor 
{
    int ancesstor[][];
    int row,col;

    public TreeAncestor(int n, int[] parent) 
    {
        row=n;
        col = (int) (Math.log(n)/Math.log(2))+1;
        ancesstor = new int[row][col];

        for(int i=0 ; i<row ; i++)
        {
            ancesstor[i][0]=parent[i];
        }    

        for(int j=1 ; j<col ;j++)
        {
            for(int i=0; i<row ; i++)
            {
                if(ancesstor[i][j-1]!=-1){
                    ancesstor[i][j] = ancesstor[ancesstor[i][j-1]][j-1];
                }
                else
                {
                    ancesstor[i][j] = -1;
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) 
    {
        for(int j=0 ; j<col ; j++)
        {
            if(((k>>j) & 1)==1){
                node = ancesstor[node][j];
            }

            if(node==-1){
                return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */