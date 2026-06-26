class Solution {
    public int maxProduct(int[] arr) {

        int n=arr.length;
        int lastMax = arr[0];
        int lastMin = arr[0];
        int max = arr[0];

        for(int i=1 ; i<n ; i++)
        {
            int c1 = arr[i];
            int c2 = arr[i]*lastMax;
            int c3 = arr[i]*lastMin;

            lastMax = Math.max(c1, Math.max(c2, c3));
            lastMin = Math.min(c1, Math.min(c2, c3));

            max = Math.max(max, Math.max(lastMax, lastMin));
        }

        return max;       
    }
}