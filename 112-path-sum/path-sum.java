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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return pathExist(root, targetSum, 0);
    }

    public boolean pathExist(TreeNode root, int k, int sum){
        if(root==null){
            return false;
        }

        sum += root.val;
        if(isLeaf(root)){
            return sum==k;
        }

        boolean left = pathExist(root.left, k, sum);
        boolean right = pathExist(root.right, k, sum);

        if(left || right){
            return true;
        }

        return false;
    }

    public boolean isLeaf(TreeNode root){
        if(root.right==null && root.left==null){
            return true;
        }

        return false;
    }
}