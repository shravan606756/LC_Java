class Solution {
    int idx=0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        int n = preorder.length;
        for(int i=0 ; i<n ; i++)
        {
            map.put(inorder[i], i);
        }

        return sol(preorder, 0, n-1);
    }

    public TreeNode sol(int preorder[], int low, int high){
        if(low>high){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;

        int id = map.get(root.val);
        root.left = sol(preorder, low, id-1);
        root.right = sol(preorder, id+1, high);

        return root;
    }
}