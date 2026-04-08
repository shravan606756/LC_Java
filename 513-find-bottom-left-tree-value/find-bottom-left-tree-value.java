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
    public int findBottomLeftValue(TreeNode root)
    {
       bfs(root);
       return res;
    }

    void bfs(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp = new ArrayList<>(size);

            while(size>0)
            {
                TreeNode t = q.peek();
                q.poll();
                temp.add(t.val);

                if(t.left!=null)
                {
                    q.offer(t.left);
                }
                if(t.right!=null)
                {
                    q.offer(t.right);
                }
                size--;
            }
            res=temp.get(0);
        }
    }
}