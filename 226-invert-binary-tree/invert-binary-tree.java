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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
        {
            return null;
        }

        SwapNode(root);

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void SwapNode(TreeNode p)
    {
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;
    }
}