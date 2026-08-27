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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> desc = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }    

        TreeNode temp = root;
        while(temp!=null){
            asc.push(temp);
            temp=temp.left;
        }

        temp=root;
        while(temp!=null){
            desc.push(temp);
            temp=temp.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while(i!=null && j!=null && i!=j && i.val<j.val)
        {
            int sum = i.val+j.val;

            if(sum==k){
                return true;
            }else if(sum<k){
                i=getSmall();
            } else{ 
                j = getBig(); 
            }
        }

        return false;
    }

    public TreeNode getSmall(){
        if(asc.isEmpty()){
            return null;
        }

        TreeNode small = asc.peek();
        asc.pop();

        TreeNode rightChild = small.right;

        while(rightChild!=null){
            asc.push(rightChild);
            rightChild=rightChild.left;
        }

        return small;
    }

    public TreeNode getBig(){
        if(desc.isEmpty()){
            return null;
        }

        TreeNode big = desc.peek();
        desc.pop();
        TreeNode leftChild = big.left;
        
        while(leftChild!=null){
            desc.push(leftChild);
            leftChild = leftChild.right;
        }

        return big;
    }
}