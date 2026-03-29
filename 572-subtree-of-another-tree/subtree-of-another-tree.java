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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) 
    {
        if(root==null)
        {
            return false;
        }

        if(subRoot==null)
        {
            return true;
        }

        Boolean full = isSame(root , subRoot);
        Boolean leftHalf = isSubtree(root.left , subRoot);
        Boolean rightHalf = isSubtree(root.right , subRoot);

        if(full)
        {
            return true;
        }               

        if(leftHalf || rightHalf)
        {
            return true;
        } 

        return false;
    }

    public boolean isSame(TreeNode p, TreeNode q) 
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

        Boolean r1 = isSame(p.left , q.left);
        Boolean r2 = isSame(p.right , q.right);

        if(r1==true && r2==true)
        {
            return true;
        }
        return false;
    }
}