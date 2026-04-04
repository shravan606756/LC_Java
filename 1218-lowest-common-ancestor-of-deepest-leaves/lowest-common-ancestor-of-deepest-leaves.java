/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    class pair
    {
        int d;
        TreeNode n;

        pair(int d , TreeNode n)
        {
            this.d=d;;
            this.n=n;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root)
    {
        return solve(root).n;
    }

    pair solve(TreeNode root)
    {
        if(root==null)
        {
            return new pair(0,null);
        }
        
        pair left = solve(root.left);
        pair right = solve(root.right);

        if(left.d==right.d)
        {
            return new pair(left.d+1 , root);
        }

        if(left.d>right.d)
        {
            return new pair(left.d+1 , left.n);
        }

        
        return new pair(right.d+1 , right.n);
    }
}