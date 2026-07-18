class Solution {
    public int maxProduct(int[] arr) 
    {
        int n = arr.length;

        int ans = arr[0];

        int lastMin = arr[0];
        int lastMax = arr[0];

        for(int i=1 ; i<n ; i++)
        {
            int c1 = arr[i];
            int c2 = arr[i]*lastMax;
            int c3 = arr[i]*lastMin;

            lastMin = Math.min(c1, Math.min(c2, c3));
            lastMax = Math.max(c1, Math.max(c2, c3));

            ans = Math.max(ans, Math.max(lastMax, lastMin));
        }

        return ans;
    }
}