class Solution {
    public int maxAbsoluteSum(int[] arr) 
    {
        int BestMax = getMaxBest(arr);
        int BestMin = getMinBest(arr);

        return Math.max(Math.abs(BestMax), Math.abs(BestMin));
    }

    public int getMaxBest(int arr[])
    {
        int prevBest = arr[0];
        int ans = arr[0];
        for(int i=1 ; i<arr.length ; i++)
        {
            int c1 = arr[i];
            int c2 = prevBest+arr[i];

            prevBest = Math.max(c1, c2);
            ans = Math.max(ans, prevBest);
        }

        return ans;
    }

    public int getMinBest(int arr[])
    {
        int prevBest = arr[0];
        int ans = arr[0];
        for(int i=1 ; i<arr.length ; i++)
        {
            int c1 = arr[i];
            int c2 = prevBest+arr[i];

            prevBest = Math.min(c1, c2);
            ans = Math.min(ans, prevBest);
        }

        return ans;
    }
}