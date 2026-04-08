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
    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) 
    {
        func(root);
        return max;
    }

    int func(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int l = func(root.left);
        int r = func(root.right);

        //2 cases
        max = Math.max(max , l+r);//niche hi milgya ans

        return Math.max(l,r)+1;//uppar bhejna pdda ans
    }

}