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
    public boolean findTarget(TreeNode root, int k) 
    {
        if(root==null)
        {
            return false;
        }

        List<Integer> list = new ArrayList<>();

        InOrder(root , list);
        
        if(Solve2Sum(list,k))
        {
            return true;
        }
        return false;
    }

    public void InOrder(TreeNode root , List<Integer> list)
    {
        if(root==null)
        {
            return;
        }

        InOrder(root.left , list);
        list.add(root.val);
        InOrder(root.right , list);
    }

    public boolean Solve2Sum(List<Integer>list , int k)
    {
        int n = list.size();

        int sum=0,l=0,r=n-1;

        while(l<r)
        {
            sum=list.get(l)+list.get(r);

            if(sum==k)
            {
                return true;
            }

            else if(sum<k)
            {
                l++;
            }
            else{
                r--;
            }
        }

        return false;
    } 
}