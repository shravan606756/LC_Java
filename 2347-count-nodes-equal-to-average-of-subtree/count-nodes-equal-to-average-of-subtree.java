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
    int res=0;

    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        sol(root);
        return res;
    }

    public void sol(TreeNode root){
        if(root==null){
            return;
        }

        int data[] = findSum(root);

        int sum = data[0];
        int c = data[1];
        
        if((sum/c)==root.val){
            res++;
        }

        sol(root.left);
        sol(root.right);
    }
  
    public int[] findSum(TreeNode root){
        if(root==null){
            return new int[]{0, 0};
        }
        
        int left[] = findSum(root.left);
        int right[] = findSum(root.right);

        int sum = left[0] + right[0] + root.val;
        int c = left[1] + right[1] + 1;
        return new int[]{sum, c};
    }
}