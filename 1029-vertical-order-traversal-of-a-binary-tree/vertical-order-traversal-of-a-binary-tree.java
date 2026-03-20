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
class Solution 
{
    public List<List<Integer>> verticalTraversal(TreeNode root) 
    {
        Queue<tuple> q = new LinkedList<>();
        Map<Integer , List<tuple>> map = new TreeMap<>();
        q.add(new tuple(root , 0 , 0));
        while(!q.isEmpty())
        {
            tuple t = q.poll();
            TreeNode n = t.n;
            int hd = t.hd;
            int level = t.level;

            map.putIfAbsent(hd , new ArrayList<>());
            map.get(hd).add(t);

            if(n.left!=null)
            {
                q.add(new tuple(n.left , hd-1 , level+1));
            }

            if(n.right!=null)
            {
                q.add(new tuple(n.right , hd+1 , level+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(List<tuple> list : map.values())
        {
            Collections.sort(list , (a,b) -> {
                if(a.level==b.level){
                    return a.n.val - b.n.val;
                }

                else{
                    return a.level - b.level;
                }
            });

            List<Integer> col = new ArrayList<>();

            for(tuple t : list)
            {
                col.add(t.n.val);
            }

            res.add(col);
        }   

        return res;
    }
}

class tuple
{
    TreeNode n;
    int hd;
    int level;

    tuple(TreeNode n , int hd , int level)
    {
        this.n = n;
        this.hd = hd;
        this.level = level;
    }
}