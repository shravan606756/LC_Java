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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    public boolean findTarget(TreeNode root, int k) 
    {
        if(root==null)
        {
            return false;
        }

        TreeNode t=root;

        while(t!=null)
        {
            asc.push(t);
            t = t.left;
        }

        t=root;
        
        while(t!=null)
        {
            desc.push(t);
            t = t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while(i!=null && j!=null && i!=j)
        {
            int sum = i.val+j.val;

            if(sum==k)
            {
                return true;
            }

            else if(sum<k)
            {
                i=getSmall();
            }
            else{
                j = getBig();
            }
        }

        return false;
    } 

    public TreeNode getSmall()
    {
        if(asc.isEmpty())
        {
            return null;
        }
        TreeNode poped = asc.pop();
        TreeNode temp = poped.right;

        while(temp!=null)
        {
            asc.push(temp);
            temp=temp.left;
        } 

        return poped;
    }

    public TreeNode getBig()
    {
        if(desc.isEmpty())
        {
            return null;
        }

        TreeNode poped = desc.pop();
        TreeNode temp = poped.left;

        while(temp!=null)
        {
            desc.push(temp);
            temp=temp.right;
        }

        return poped;
    }
}