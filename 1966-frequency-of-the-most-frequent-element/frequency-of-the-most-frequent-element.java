class Solution {
    public int maxFrequency(int[] arr, int k) 
    {
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        /*int pre[] = new int[n+1];

        for(int i=0 ; i<n ; i++)
        {
            pre[i+1] = pre[i]+arr[i];
        }

        for(int i=0 ; i<n ; i++)
        {
            int freq = bs(arr, k, pre, i);
            max = Math.max(max, freq);
        }

        return max == Integer.MIN_VALUE ? 0 : max;*/
        long have = 0;
        int low = 0;

        for (int high = 0; high < n; high++) 
        {
            have += arr[high];

            long want = 1L * (high - low + 1) * arr[high];

            while (want - have > k)
            {
                have -= arr[low];
                low++;
                want = 1L * (high - low + 1) * arr[high];
            }

            max = Math.max(max, high - low + 1);
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    /*public int bs(int arr[], int k, int pre[], int target_idx){
        int l=0,r=target_idx;
        int res = target_idx;
        while(l<=r){
            int mid = l + (r-l) /2;

            int want = (target_idx-mid+1) * arr[target_idx];
            int have = pre[target_idx+1]-pre[mid];

            if(want-have<=k){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return target_idx - res +1;
    }*/
}