class Solution {
    public int minSubArrayLen(int target, int[] arr) 
    {
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        int sum=0;

        int low=0;
        for(int high=0 ; high<n ; high++){
            sum += arr[high];

            while(sum>=target){
                int len = high-low+1;
                res = Math.min(res, len);
                
                sum-=arr[low];
                low++;
            }
        }

        return res ==Integer.MAX_VALUE ? 0 : res;
    }
}