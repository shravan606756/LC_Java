class Solution 
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();

        Map<Character , Integer> freq = new HashMap<>();

        int low=0;
        int max=0;
        for(int high=0; high<n ; high++)
        {
            char x = s.charAt(high);
            freq.put(x , freq.getOrDefault(x,0)+1);

            while(freq.get(x)>1)
            {
                char d = s.charAt(low);
                int c = freq.get(d)-1;
                if(c==0)
                {
                    freq.remove(d);
                }
                freq.put(d , c);
                low++;
            }

            int len = high-low+1;
            max = Math.max(max , len);
        }   

        return max;
    }
}