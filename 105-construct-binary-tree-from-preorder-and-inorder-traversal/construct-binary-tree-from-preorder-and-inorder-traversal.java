class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        int n = preorder.length;

        int idx[] = new int[1];

        HashMap <Integer , Integer> map = new HashMap<>();

        for(int i=0 ; i<inorder.length ; i++)
        {
            map.put(inorder[i] , i);
        }

        return func(preorder , inorder , idx , map , 0 , n-1);
    }

    public TreeNode func(int preorder[] , int inorder[] , int idx[] , HashMap<Integer , Integer> map , int low , int high )
    {
        if(low>high)
        {
            return null;
        }
        
        int rootVal = preorder[idx[0]];
        TreeNode root = new TreeNode(rootVal);
        int id = map.get(rootVal);
        idx[0]++;

        root.left = func(preorder , inorder , idx , map , low , id-1);
        root.right = func(preorder , inorder , idx , map , id+1 , high);

        return root;
    }
}