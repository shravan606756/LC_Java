class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) 
    {
        int n = arr.length;

        int l=0 , h=k-1;
        int sum=0 , c=0;
        for(int i=0 ; i<=h ; i++)
        {
            sum +=arr[i];
        }
        int avg = sum/k;
        if(isValid(avg , threshold))
        {
            c++;
        }
        
        while(h<n-1)
        {
            sum -= arr[l]; 
            l++;
            h++;
            sum += arr[h];
            avg = sum/k;

            if(isValid(avg , threshold))
            {
                c++;
            } 
        }

        return c;
    }

    public boolean isValid(int avg , int threshold)
    {
        if(avg>=threshold)
        {
            return true;
        }
        return false;
    }
}