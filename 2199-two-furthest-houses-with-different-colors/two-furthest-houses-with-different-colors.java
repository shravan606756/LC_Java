class Solution {
    public int maxDistance(int[] arr) 
    {
        int n = arr.length;
        int max=-1;
        
        /*int i=0;
        while(arr[i]==arr[n-1])
        {
            i++;
        }
        max = Math.max(max , Math.abs(i-(n-1)));

        i = n-1;
        while(arr[i]==arr[0])
        {
            i--;
        }
        max = Math.max(max , i);
        return max;*/

        for(int i=0 ; i<n ; i++)
        {
            if(arr[i]!=arr[0])
            {
                max = Math.max(max , i);
            }

            if(arr[i]!=arr[n-1])
            {
                max = Math.max(max , Math.abs(i-(n-1)));
            }
        }

        return max;
    }
}