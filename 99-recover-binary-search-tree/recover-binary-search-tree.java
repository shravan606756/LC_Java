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
    int wrong=0;
    TreeNode wrong1first=null;
    TreeNode wrong1sec=null;
    TreeNode wrong2first=null;
    TreeNode wrong2sec=null;
    TreeNode prev=null;

    public void recoverTree(TreeNode root) 
    {
        func(root);

        if(wrong==1)
        {
            swap(wrong1first , wrong1sec);
        }

        else
        {
            swap(wrong1first , wrong2sec);
        }
    }

    public void func(TreeNode root)
    {
        if(root==null)
        {
            return;
        }

        func(root.left);
        //core logic : 

        if(prev==null)
        {
            prev=root;
        }

        else
        {
            if(prev.val>=root.val)
            {
                if(wrong==0)
                {
                    wrong1first=prev;
                    wrong1sec=root;
                    wrong++;
                }

                else{
                    wrong2first=prev;
                    wrong2sec=root;
                    wrong++;
                }
            }
            prev=root;
        }        
        func(root.right);
    }   

    public void swap(TreeNode a , TreeNode b)
    {
        int temp = a.val;
        a.val=b.val;
        b.val=temp;
    } 
}