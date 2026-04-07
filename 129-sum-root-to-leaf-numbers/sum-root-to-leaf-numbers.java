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
    public int sumNumbers(TreeNode root) 
    {
        int sum = func(root , 0);
        return sum;
    }

    public int func(TreeNode root , int sum)
    {
        if(root==null)
        {
            return 0;
        }

        sum = sum*10 + root.val;
        if(isLeaf(root))
        {
            return sum;
        }
        
        int left = func(root.left , sum);
        int right = func(root.right , sum);

        return left + right;
    }

    public boolean isLeaf(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            return true;
        }

        return false;
    }
}