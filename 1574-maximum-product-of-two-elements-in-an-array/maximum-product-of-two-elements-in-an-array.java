class Solution {
    public int maxProduct(int[] arr) 
    {
        int n = arr.length;
        Arrays.sort(arr);

        int res1 = (arr[0]-1)*(arr[1]-1);
        int res2 = (arr[n-1]-1)*(arr[n-2]-1);

        return Math.max(res1, res2);    
    }
}