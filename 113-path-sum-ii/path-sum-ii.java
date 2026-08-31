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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return res;
        }

        List<Integer> path = new ArrayList<>();

        sol(root, targetSum, path, 0);

        return res;
    }

    public void sol(TreeNode root, int k, List<Integer> path, int sum){
        if(root==null){
            return;
        }
        
        sum += root.val;
        path.add(root.val);

        if(isLeaf(root) && sum==k){
            res.add(new ArrayList(path));
        }

        sol(root.left, k, path, sum);
        sol(root.right, k, path, sum);

        path.remove(path.size()-1);
    }

    public boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null){
            return true;
        }

        return false;
    }
}