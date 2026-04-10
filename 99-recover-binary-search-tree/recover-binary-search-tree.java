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

    public void recoverTree(TreeNode root) 
    {
        List<TreeNode> list = new ArrayList<>();
        Inorder(root , list);
        Refactor(list);
    }

    public void Inorder(TreeNode root , List<TreeNode> list)
    {
        if(root==null)
        {
            return;
        }

        Inorder(root.left , list);
        list.add(root);
        Inorder(root.right , list);
    }

    public void Refactor(List<TreeNode> list)
    {
        for(int i=1 ; i<list.size() ; i++)
        {
            if(list.get(i-1).val>=list.get(i).val)
            {
                wrong++;
                if(wrong==1)
                {
                    wrong1first=list.get(i-1);
                    wrong1sec=list.get(i);
                }
                else{
                    wrong2first=list.get(i-1);
                    wrong2sec=list.get(i);
                }
            }
        }

        if(wrong==1)
        {
            swap(wrong1first , wrong1sec);
        }
        else{
            swap(wrong1first , wrong2sec);
        }
    }

    public void swap(TreeNode a , TreeNode b)
    {
        int temp = a.val;
        a.val=b.val;
        b.val=temp;
    }
}