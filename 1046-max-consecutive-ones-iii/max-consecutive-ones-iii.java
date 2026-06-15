class Solution {
    public int longestOnes(int[] arr, int k) 
    {
        int n  =arr.length;
        int freq[] = new int[2];
        int max=Integer.MIN_VALUE, low=0;
        for(int high=0 ; high<n ; high++)
        {
            freq[arr[high]]++;
            if(freq[0]>k)
            {
                int count = arr[low];
                freq[count]--;
                low++;
            }

            int len = high-low+1;
            max = Math.max(max, len);
        }

        return max==Integer.MIN_VALUE ? 0 : max;
    }
}