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
    public TreeNode createBinaryTree(int[][] descriptions) 
    {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childs = new HashSet<>();

        for(int x[] : descriptions)
        {
            int parent = x[0];
            int child = x[1];
            int isLeft = x[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            if(isLeft==1){
                map.get(parent).left = map.get(child);
            }else{
                map.get(parent).right = map.get(child);
            }

            childs.add(child);
        }

        for(int x[] : descriptions){
            int parent = x[0];

            if(!childs.contains(parent)){
                return map.get(parent);
            }
        }

        return null;
    }
    
}