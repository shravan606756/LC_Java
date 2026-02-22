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
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
        {
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            /*
                writing que.size() inside while loop because
                of different no. of nodes at each level , hence 
                size must be changed dynamically withrespect to
                current level
            */
            int size = que.size();

            /*
                separate List of Integer due to function 
                accepts List<List<Integer>> , we want values 
                to return not the nodes
             */
            List<Integer> level = new ArrayList<>();
            for(int i=0 ; i<size ; i++)
            {
                TreeNode curr = que.poll();

                if(curr.left != null)
                {
                    que.offer(curr.left);
                }

                if(curr.right != null)
                {
                    que.offer(curr.right);
                }
                
                level.add(curr.val);
            }
            res.add(level);
        }

        return res;
    }
}