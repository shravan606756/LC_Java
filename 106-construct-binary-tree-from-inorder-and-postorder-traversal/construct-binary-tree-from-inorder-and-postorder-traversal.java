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
    Map<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        int n = postorder.length;
        idx = n-1;
        for(int i=0 ; i<n ; i++)
        {
            map.put(inorder[i], i);
        }

        return sol(postorder, 0, n-1);
    }

    public TreeNode sol(int [] postorder, int low, int high){

        if(low>high){
            return null;
        }

        TreeNode root = new TreeNode(postorder[idx]);
        idx--;

        int id = map.get(root.val);

        root.right = sol(postorder, id+1, high);
        root.left = sol(postorder, low, id-1);

        return root;
    }
}