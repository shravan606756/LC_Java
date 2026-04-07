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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        List<List<Integer>> list = new ArrayList<>();
        func(root , targetSum , list , new ArrayList<>() , 0);
        return list;    
    }

    public void func(TreeNode root , int k , List<List<Integer>> list, List<Integer> path , int sum)
    {
        if(root==null)
        {
            return;
        }

        path.add(root.val);
        sum=sum+root.val;

        if(isLeaf(root) && sum==k)
        {
            list.add(new ArrayList<>(path));
        }

        func(root.left , k , list ,path, sum);
        func(root.right , k , list ,path, sum);

        path.remove(path.size()-1);
    }

    public boolean isLeaf(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            return true;
        }
        return false;
    }
}