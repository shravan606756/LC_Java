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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        ArrayList<List<Integer>> res=  new ArrayList<>();
        if(root == null)
        {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        Boolean rev = false;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer>temp = new ArrayList<>(size);

            while(size>0)
            {
                TreeNode t = q.peek();
                temp.add(t.val);
                q.poll();

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
            if(rev==true)
            {
                Collections.reverse(temp);
            }
            res.add(temp);
            rev = !rev;
        }

        return res;
    }
}