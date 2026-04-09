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
    int totalTilt=0;
    public int findTilt(TreeNode root) {
        func(root);
        return totalTilt;
    }

    public int func(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int l = func(root.left);
        int r = func(root.right);
        
        totalTilt += Math.abs(l-r);
        
        return l+r+root.val;
    }
}