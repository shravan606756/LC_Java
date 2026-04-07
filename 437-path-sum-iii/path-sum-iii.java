class Solution {
    public int pathSum(TreeNode root, int targetSum) 
    {
        if(root==null)
        {
            return 0;
        }

        long sum = 0; 

        int self = func(root , targetSum , sum);
        int left = pathSum(root.left , targetSum);
        int right = pathSum(root.right , targetSum);

        return self + left + right;   
    }

    public int func(TreeNode root , int k , long sum)
    {
        if(root==null)
        {
            return 0;
        }

        sum = sum + root.val;

        int c = 0;
        if(sum == k)
        {
            c++;
        }

        c += func(root.left , k , sum);
        c += func(root.right , k , sum);

        return c;
    }
}