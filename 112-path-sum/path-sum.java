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
    public boolean hasPathSum(TreeNode root, int targetSum) 
    {
        return func(root , targetSum , 0);
    }

    boolean func(TreeNode root , int k , int sum)
    {
        if(root==null)
        {
            return false;
        }

        sum = sum+root.val;
        if(isLeaf(root))
        {
            return sum==k;
        }

        boolean left = func(root.left , k , sum);
        boolean right = func(root.right , k , sum);

        if(left==true || right==true)
        {
            return true;
        }

        return false;
    }

    boolean isLeaf(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            return true;
        }

        return false;
    }
}