class Solution {
    public boolean hasAllCodes(String s, int k) 
    {
        int total = (int) Math.pow(2,k);
        int n = s.length();
        if(n-k+1<total) return false;

        Set<String> set = new HashSet<>();

        int low=0;

        for(int high=0 ; high<n ; high++)
        {
            while(!isValid(k , high , low))
            {
                low++;
            }


            if((high-low+1) == k)
            {
                set.add(s.substring(low , high+1));
            
                if(set.size()==total)
                {
                    return true;
                }
            } 
        }
        return false;
    }

    public boolean isValid(int k , int high ,  int low)
    {
        int size = high-low+1;

        if(size <=k)
        {
            return true;
        }

        return false;
    }
}