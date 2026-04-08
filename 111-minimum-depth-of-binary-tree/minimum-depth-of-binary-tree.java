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
    public int minDepth(TreeNode root) 
    {
        return bfs(root);   
    }

    int bfs(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        int d=1;

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-- > 0)
            {
                TreeNode t = q.peek();
                q.poll();

                if(t.left==null && t.right==null)
                {
                    return d;
                }

                if(t.left!=null)
                {
                    q.offer(t.left);
                }
                if(t.right!=null)
                {
                    q.offer(t.right);
                }
            }
            d++;
        }

        return -1;
    }
}