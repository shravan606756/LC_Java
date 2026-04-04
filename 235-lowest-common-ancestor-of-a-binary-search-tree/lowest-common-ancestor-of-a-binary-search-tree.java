/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null)
        {
            return null;
        }    

        if(p.val>q.val)
        {
            dfs(root , q , p);
        }
        else{
            dfs(root , p , q);
        }
        return ans;
    }

    public void dfs(TreeNode root , TreeNode p , TreeNode q)
    {
        if(root==null)
        {
            return;
        }
        if(root.val==p.val || root.val==q.val)
        {
            ans = root;
            return;
        }

        if(root.val<p.val)
        {
            dfs(root.right , p , q);
        }
        else if(root.val > q.val)
        {
            dfs(root.left , p , q);
        }

        else
        {
            ans = root;
        }
    }
}