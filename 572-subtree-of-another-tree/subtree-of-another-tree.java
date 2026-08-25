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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
          if(subRoot==null) {
            return true;
        }

        if(root==null) {
            return false;
        }
        
        boolean fullTreeIsSame = isSame(root, subRoot);
        boolean leftIsSame = isSubtree(root.left, subRoot);
        boolean rightIsSame = isSubtree(root.right, subRoot);

        if(fullTreeIsSame){
            return true;
        }        

        if(leftIsSame==true || rightIsSame==true){
            return true;
        }

        return false;
    }

    public boolean isSame(TreeNode r1, TreeNode r2) {
        if(r1==null && r2==null) {
            return true;
        }

        if(r1==null || r2==null) {
            return false;
        }

        if(r1.val!=r2.val) {
            return false;
        }

        boolean c1 = isSame(r1.left, r2.left);
        boolean c2 = isSame(r1.right, r2.right);

        if(c1==true && c2==true){
            return true;
        }

        return false;
    }
}