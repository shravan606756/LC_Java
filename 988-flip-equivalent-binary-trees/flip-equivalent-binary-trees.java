class Solution {
    public boolean flipEquiv(TreeNode r1, TreeNode r2) 
    {
        if(r1==null && r2==null)
        {
            return true;
        }

        if(r1==null || r2==null)
        {
            return false;
        }

        if(r1.val!=r2.val)
        {
            return false;
        }

        boolean same = flipEquiv(r1.left , r2.left) && flipEquiv(r1.right,r2.right);
        boolean inverted = flipEquiv(r1.left , r2.right) && flipEquiv(r1.right , r2.left);

        return same || inverted;
    }
}