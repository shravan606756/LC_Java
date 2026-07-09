class Solution {
    public boolean[] pathExistenceQueries(int n, int[] arr, int maxDiff, int[][] queries) 
    {
        //simulating result instead of actully building graph

        boolean ans[] = new boolean[queries.length];

        int component[] = new int[arr.length];
        component[0]=0;

        for(int i=1; i<arr.length ; i++)
        {
            if((arr[i]-arr[i-1])<=maxDiff)
            {
                component[i]=component[i-1];
            }

            else{
                component[i] = component[i-1]+1;
            }
        }

        for(int i=0 ; i<queries.length ; i++)
        {
            if(component[queries[i][0]] == component[queries[i][1]])
            {
                ans[i]=true;
            }else{
                ans[i]=false;
            }
        }

        return ans;
    }
}