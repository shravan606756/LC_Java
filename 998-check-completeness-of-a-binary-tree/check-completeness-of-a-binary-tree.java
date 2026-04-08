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
    
    public boolean isCompleteTree(TreeNode root) 
    {
        if(root==null)
        {
            return true;
        }    

        Queue<TreeNode> q = new LinkedList<>();
        boolean nullSeen = false;
        q.offer(root);

        while(!q.isEmpty())
        {
            TreeNode t = q.peek();
            q.poll();

            if(t==null)
            {
                nullSeen=true;
            }
            else{
                if(nullSeen==true)
                {
                    return false;
                }
                q.offer(t.left);
                q.offer(t.right);
            }
        }

        return true;
    }
}