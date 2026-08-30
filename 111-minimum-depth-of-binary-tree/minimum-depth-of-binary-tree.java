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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return sol(root, 1);
    }

    public int sol(TreeNode root, int d){
        if(root==null){
            return Integer.MAX_VALUE;
        }

        if(root.left==null && root.right==null){
            return d;
        }
        int left = sol(root.left, d+1);
        int right = sol(root.right, d+1);
        return Math.min(left, right); 
    }
}