class Solution {
    public double findMaxAverage(int[] arr, int k) 
    {
        int n=arr.length;
        int l=0;
        int h=k-1;
        int sum=0;
        for(int i=0 ; i<=h ; i++)
        {
            sum += arr[i];
        }
        double avg = (double)sum/k;
        double max = avg;
        while(h<n-1)
        {
            sum = sum - arr[l];
            l++;
            h++;
            sum = sum + arr[h];
            avg = (double) sum/k;
            max = Math.max(max , avg);
        }
        return max;
    }
}