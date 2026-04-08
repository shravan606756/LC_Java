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
    int max=-1;
    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        func(root , 0);
        return res;        
    }

    void func(TreeNode root , int currDepth)
    {
        if(root==null)
        {
            return;
        }

        if(currDepth>max)
        {
            max=currDepth;
            res=root.val;
        }
        func(root.left,currDepth+1);
        func(root.right ,currDepth+1);
    }
}