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
    public List<Integer> rightSideView(TreeNode root) 
    {
        return bfs(root); 
    }

    public List<Integer> bfs(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty())
        {   
            int n = q.size();
            TreeNode x = null;
            while(n>0)
            {
                x = q.peek();
                q.poll();

                if(x.left!=null)
                {
                    q.offer(x.left);
                }

                
                if(x.right!=null)
                {
                    q.offer(x.right);
                }

                n--;
            }
            res.add(x.val);
        }   

        return res;     
    }        
}