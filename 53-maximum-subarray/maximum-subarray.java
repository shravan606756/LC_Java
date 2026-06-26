class Solution {
    public int maxSubArray(int[] arr) 
    {
        int n = arr.length;

        int ans = arr[0];
        int prevBest = arr[0];

        for(int i=1 ; i<n ; i++){
            int c1 = arr[i];
            int c2 = arr[i]+prevBest;

            prevBest = Math.max(c1, c2);
            ans = Math.max(ans, prevBest);
        }

        return ans;
    }
}