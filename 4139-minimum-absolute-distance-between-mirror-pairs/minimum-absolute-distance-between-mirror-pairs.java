class Solution {
    public int minMirrorPairDistance(int[] arr) 
    {
        int n = arr.length;
        Map<Integer,Integer> table = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++)
        {
            int rev = reverse(arr[i]);
            int curr=0;
            if(table.containsKey(arr[i]))
            {
                curr = i-table.get(arr[i]);
                min = Math.min(min , curr);
            }

            table.put(rev,i);
        }  

        if(min==Integer.MAX_VALUE) return -1;
        return min; 
    }

    int reverse(int x)
    {
        int res =0;
        int last=0;
        while(x>0)
        {
            last = x%10;
            res = res*10+last;
            x=x/10;
        }
        return res;
    }
}