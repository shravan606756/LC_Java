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
    public int maxPathSum(TreeNode root) 
    {
        func(root);
        return max;
    }   

    public int func(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        //using Math.max with 0 to avoid -ve recursive paths
        int l = Math.max(0,func(root.left));
        int r = Math.max(0,func(root.right));

        //3 case : 
        int niche_milgya_ans = l+r+root.val;//(1)

        int koi_ek_acha = Math.max(l,r) + root.val;//(2)

        int sirf_root_acha = root.val;//(3)
        
        //find max of 3
        max = Math.max(max , Math.max(niche_milgya_ans , Math.max(koi_ek_acha , sirf_root_acha)));        

        //can only return case 2 and 3 for other recursive search of max path 
        return Math.max(koi_ek_acha , sirf_root_acha);
    }
}