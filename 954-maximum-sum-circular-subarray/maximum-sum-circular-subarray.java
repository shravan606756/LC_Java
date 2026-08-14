class Solution
{
    public int maxSubarraySumCircular(int[] arr) 
    {
        int n = arr.length;
        int totalSum=0;

        for(int x : arr){
            totalSum += x;
        }

        int linearMin = findLinearMin(arr);
        int linearMax = findLinearMax(arr);

        if(linearMax<0){
            return linearMax;
        }

        int circularMax = totalSum-linearMin;
        int res = Math.max(circularMax, linearMax);

        return res;
    }

    public int findLinearMax(int arr[]){
        int n = arr.length;

        int max = arr[0];
        int prevMax = arr[0];

        for(int i=1 ; i<n ; i++)
        {
            int c1 = arr[i];
            int c2 = arr[i]+prevMax;

            prevMax = Math.max(c1, c2);
            max = Math.max(max, prevMax);
        }

        return max;
    }

    public int findLinearMin(int arr[]){
        int n = arr.length;

        int min = arr[0];
        int prevMin = arr[0];

        for(int i=1 ; i<n ; i++)
        {
            int c1 = arr[i];
            int c2 = arr[i]+prevMin;

            prevMin = Math.min(c1, c2);
            min = Math.min(min, prevMin);
        }

        return min;
    }
}