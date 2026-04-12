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
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        int n = postorder.length;

        int idx[] = new int [1];
        idx[0] = n-1;

        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++)
        {
            map.put(inorder[i] , i);
        }    

        return func(postorder , inorder , map , idx , n, 0 , n-1);
    }

    public TreeNode func(int postorder[] , int inorder[] ,HashMap<Integer , Integer>map ,int idx[] , int n , int low , int high)
    {
        if(low>high)
        {
            return null;
        }

        int rootVal = postorder[idx[0]];
        TreeNode root = new TreeNode(rootVal);
        int id = map.get(rootVal);
        idx[0]--;

        root.right = func(postorder , inorder , map ,idx , n , id+1 , high);
        root.left = func(postorder , inorder , map ,idx , n , low , id-1);

        return root;
    }
}