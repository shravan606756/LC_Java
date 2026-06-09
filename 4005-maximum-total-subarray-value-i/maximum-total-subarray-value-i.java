class Solution {
    public long maxTotalValue(int[] arr, int k) 
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int x : arr)
        {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        long val = (long)max-min;
        long res = (long) val*k;
        return res;
    }
}