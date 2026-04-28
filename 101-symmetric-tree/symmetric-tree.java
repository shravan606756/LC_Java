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
class Solution {
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }
        return same(root.left , root.right);
    }

    public boolean same(TreeNode l , TreeNode r)
    {
        if(l==null && r==null)
        {
            return true;
        }
        if(l==null || r==null)
        {
            return false;
        }

        if(l.val!=r.val)
        {
            return false;
        }

        boolean left = same(l.left , r.right);
        boolean right = same(l.right , r.left);

        if(left==true && right==true)
        {
            return true;
        }

        return false;
    }
}