class Solution {
    public int minSubArrayLen(int target, int[] arr) 
    {
        int n = arr.length;
        int min = Integer.MAX_VALUE, sum=0, low=0;

        for(int high=0 ; high<n ; high++)
        {
            sum+=arr[high];

            while(sum>=target){
                int len = high-low+1;
                min = Math.min(min, len);

                sum -= arr[low];
                low++;
            }            
        }   

        return min ==Integer.MAX_VALUE ? 0 : min;
    }
}