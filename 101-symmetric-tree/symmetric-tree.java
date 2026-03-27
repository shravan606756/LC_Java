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
        
        return isMirror(root.left , root.right);
    }

    public static Boolean isMirror(TreeNode p , TreeNode q)
    {
        if(p==null && q==null)
        {
            return true;
        }

        if(p==null || q==null)
        {
            return false;
        }

        if(p.val!=q.val)
        {
            return false;
        }

        Boolean r1 = isMirror(p.left , q.right);
        Boolean r2 = isMirror(p.right , q.left);

        if(r1==true && r2==true)
        {
            return true;
        }

        return false;
    }
}