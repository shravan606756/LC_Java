class Solution {
    int maxD = 0;
    TreeNode ans = null;
    int totalDeepN=0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null){
            return null;
        }

        getDepth(root, 0);
        countTotalDeepestNodes(root, 0);
        lca(root, 0);

        return ans;
    }

    public void getDepth(TreeNode root, int d){
        if(root==null){
            return;
        }

        maxD = Math.max(maxD, d);

        getDepth(root.left, d+1);
        getDepth(root.right, d+1);
    }

    public int lca(TreeNode root, int d){
        if(root==null){
            return 0;
        }

        int left = lca(root.left, d+1);
        int right = lca(root.right, d+1);

        int self = 0;

        if(root.left==null && root.right==null && d==maxD){
            self = 1;
        }

        int total = left+right+self;

        if(total==totalDeepN && ans==null){
            ans=root;
        }

        return total;
    }

    public void countTotalDeepestNodes(TreeNode root, int d){
        if(root==null){
            return ;
        }

        if(d==maxD){
            totalDeepN+=1;
        }

        countTotalDeepestNodes(root.left, d+1);
        countTotalDeepestNodes(root.right, d+1);
    }
}