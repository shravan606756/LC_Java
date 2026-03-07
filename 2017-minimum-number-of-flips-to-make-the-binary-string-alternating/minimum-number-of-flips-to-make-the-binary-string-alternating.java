class Solution {
    public int minFlips(String s) 
    {
        int n =s.length();
        String t = s+s;

        int low=0 , count1=0 , count2=0 , ans=n , high=0 ;
        for(high =0 ; high<2*n ; high++)
        {
            char x = t.charAt(high);
            if(high%2==0)
            {
                if(x!='0')
                {
                    count1++;
                }
                if(x!='1')
                {
                    count2++;
                }
            }

            else
            {
                if(x!='1')
                {
                    count1++;
                }
                if(x!='0')
                {
                    count2++;
                }
            }

            if(high-low+1>n)
            {
                char d = t.charAt(low);

                if(low%2==0)
                {
                    if(d!='0')
                    {
                        count1--;
                    }
                    if(d!='1')
                    {
                        count2--;
                    }
                }
                else
                {
                    if(d!='1')
                    {
                        count1--;
                    }
                    if(d!='0')
                    {
                        count2--;
                    }
                }
                low++;
            }

            if(high-low+1==n)
            {
                ans = Math.min(ans , Math.min(count1 , count2));
            }            
        } 

        return ans;
    }
}