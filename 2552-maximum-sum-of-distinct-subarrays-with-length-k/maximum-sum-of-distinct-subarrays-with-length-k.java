class Solution {
    public long maximumSubarraySum(int[] arr, int k) 
    {
        int n = arr.length;

        Map<Integer, Integer> freq = new HashMap<>();

        long sum = 0;
        int high = 0;

        // First window
        for (high = 0; high < k; high++)
        {
            sum += arr[high];
            freq.put(arr[high], freq.getOrDefault(arr[high], 0) + 1);
        }

        long res = 0;
        int low = 0;

        if (freq.size() == k)
            res = Math.max(res, sum);

        while (high < n)
        {
            // Remove left element
            sum -= arr[low];
            int d = arr[low];
            int count = freq.get(d);

            if (count == 1)
            {
                freq.remove(d);
            }
            else
            {
                freq.put(d, count - 1);
            }

            low++;

            // Add right element
            sum += arr[high];
            freq.put(arr[high], freq.getOrDefault(arr[high], 0) + 1);
            high++;

            if (freq.size() == k)
            {
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}