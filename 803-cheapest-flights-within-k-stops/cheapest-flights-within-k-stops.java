class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
        int res[] = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src]=0;

        for(int i=0 ; i<=k ; i++)
        {
            int temp[] = Arrays.copyOf(res,n);

            for(int j=0 ; j<flights.length ; j++)
            {
                int u = flights[j][0];
                int v = flights[j][1];
                int wt = flights[j][2];

                if(res[u]!=Integer.MAX_VALUE && temp[v]>res[u]+wt)
                {
                    temp[v] = res[u]+wt;
                }
            }

            res=temp;
        }

        if(res[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }

        return res[dst];
    }
}