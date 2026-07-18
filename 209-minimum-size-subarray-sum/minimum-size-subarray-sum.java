class Solution {
    public int minSubArrayLen(int target, int[] arr) 
    {
        int n = arr.length;
        int res = Integer.MAX_VALUE;

        int low=0, sum=0;
        for(int high=0 ; high<n ; high++)
        {
            sum += arr[high];

            while(sum>=target)
            {
                res = Math.min(res, high-low+1);

                sum -= arr[low];
                low++;
            } 
        }

        return res ==Integer.MAX_VALUE ? 0 : res;
    }
}