class Solution {
    int idx=0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        int n = preorder.length;

        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return sol(preorder, 0, n-1);
    }

    public TreeNode sol(int[] preorder, int low, int high){
        if(low>high){
            return null;
        }

        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);

        int id = map.get(rootVal);

        root.left = sol(preorder, low, id-1);
        root.right = sol(preorder, id+1, high);

        return root;
    }
}