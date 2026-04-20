class Solution {
    public int maxDistance(int[] arr) 
    {
        int n = arr.length;
        int dist=0,max=-1;
        for(int i = 0; i <n ; i++)
        {
            for(int j = i+1 ; j<n ; j++)
            {
                if(arr[i]!=arr[j])
                {
                    dist = Math.abs(j-i);
                    max = Math.max(max , dist);
                }
            }
        }

        return max;
    }
}