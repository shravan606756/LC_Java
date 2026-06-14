class Solution {
    public int firstMissingPositive(int[] arr) 
    {
        int n = arr.length;
        boolean contains1 = false;

        for(int i=0 ; i<n ; i++)
        {
            if(arr[i]==1)
            {
                contains1=true;
            }

            if(arr[i]<=0 || arr[i]>n)
            {
                arr[i]=1;
            }
        }

        if(contains1==false)
        {
            return 1;
        }

        for(int i=0 ; i<n ; i++)
        {
            int num = Math.abs(arr[i]);
            int idx = num-1;

            if(arr[idx]<0)
            {
                continue;
            }

            arr[idx]*=-1;
        }

        for(int i=0 ; i<n ; i++){
            if(arr[i]>0)
            {
                return i+1;
            }
        }

        return n+1;
    }
}