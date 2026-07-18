class Solution
{
    public int maxSubarraySumCircular(int[] arr) 
    {
        int n = arr.length;
        int LinearMax = max(arr);

        if(LinearMax<0) return LinearMax; // all ele are -ve
        int sum = 0;
        for(int i=0 ; i<n ; i++)
        {
            sum+=arr[i];
        }

        int LinearMin = min(arr);
        int cir = sum-LinearMin;
        int res=0;
        res = Math.max(res , Math.max(LinearMax , cir));

        return res;
    }

    public int max(int arr[])
    {
        int n = arr.length;

        int bestEnd = arr[0];
        int res = arr[0];
        for(int i=1 ; i<n ; i++)
        {
            int v1 = arr[i];
            int v2 = arr[i]+bestEnd;

            bestEnd = Math.max(v1 , v2);

            res = Math.max(res , bestEnd);
        }
        return res;
    }

    public int min(int arr[])
    {
        int n = arr.length;

        int bestEnd = arr[0];
        int res = arr[0];
        for(int i=1 ; i<n ; i++)
        {
            int v1 = arr[i];
            int v2 = arr[i]+bestEnd;

            bestEnd = Math.min(v1 , v2);

            res = Math.min(res , bestEnd);
        }
        return res;
    }
}