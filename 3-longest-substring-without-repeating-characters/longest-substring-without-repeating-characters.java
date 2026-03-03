class Solution 
{
    public int lengthOfLongestSubstring(String s)
    {
        int n = s.length();
        int low=0 , max= 0;
        int f [] = new int[128];
        for(int high=0 ; high<n ; high++)
        {
            char c = s.charAt(high);
            f[c]++;

            while(f[c]>1)
            {
                f[s.charAt(low)]--;
                low++;
            }

            int len = high-low+1;
            max = Math.max(max , len);
        }

        return max;
    }
}