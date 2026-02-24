class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int value)
    {
        if(root==null) return 0;

        int v=value*2+root.val;

        if(root.left==null&&root.right==null)
            return v;

        return dfs(root.left,v)+dfs(root.right,v);
    }
}