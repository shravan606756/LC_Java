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
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root)
    {
        return validate(root);
    }

    public boolean validate(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }

        if(!validate(root.left)) return false;
        //core logic : 
        if(prev==null)
        {
            prev=root;
        }
        else{
            if(prev!=null && root.val<=prev.val)
            {
                return false;
            }
            prev=root;
        }

        if(!validate(root.right)) return false;

        return true;
    }
}