class Solution {

    HashMap<TreeNode,Integer> map = new HashMap<>();
    ArrayList<TreeNode> rev = new ArrayList<>();
    int idx = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        number(root);

        int row = idx;
        int col = (int)(Math.log(row)/Math.log(2))+1;

        int[][] parent = new int[row][col];
        int[] depth = new int[row];

        for(int i=0;i<row;i++)
        {
            Arrays.fill(parent[i],-1);
        }

        dfs(root,-1,0,parent,depth);

        for(int j=1;j<col;j++)
        {
            for(int i=0;i<row;i++)
            {
                if(parent[i][j-1]!=-1)
                {
                    parent[i][j]=parent[parent[i][j-1]][j-1];
                }
            }
        }

        int u = map.get(p);
        int v = map.get(q);

        if(depth[u] < depth[v])
        {
            int t = u;
            u = v;
            v = t;
        }

        int diff = depth[u]-depth[v];

        for(int j=0;j<col;j++)
        {
            if(((diff>>j)&1)==1)
            {
                u = parent[u][j];
            }
        }

        if(u==v)
        {
            return rev.get(u);
        }

        for(int j=col-1;j>=0;j--)
        {
            if(parent[u][j]!=-1 && parent[u][j]!=parent[v][j])
            {
                u = parent[u][j];
                v = parent[v][j];
            }
        }

        return rev.get(parent[u][0]);
    }

    void number(TreeNode root)
    {
        if(root==null) return;

        map.put(root,idx++);
        rev.add(root);

        number(root.left);
        number(root.right);
    }

    void dfs(TreeNode root,int par,int d,int[][] parent,int[] depth)
    {
        if(root==null) return;

        int cur = map.get(root);

        parent[cur][0]=par;
        depth[cur]=d;

        dfs(root.left,cur,d+1,parent,depth);
        dfs(root.right,cur,d+1,parent,depth);
    }
}