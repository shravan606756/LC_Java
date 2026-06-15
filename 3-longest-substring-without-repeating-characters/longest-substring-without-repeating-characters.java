class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Map<Character, Integer> freq = new HashMap<>();
        int low=0, max = Integer.MIN_VALUE;
        for(int high=0 ; high<s.length(); high ++)
        {
            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high),0)+1);

            while(freq.get(s.charAt(high))>1)
            {
                int count = freq.get(s.charAt(low));
                count--;
                if(count==0) freq.remove(s.charAt(low));
                else freq.put(s.charAt(low),count);

                low++;
            }

            if(freq.get(s.charAt(high))==1)
            {
                int len = high-low+1;
                max = Math.max(max, len);
            }
        }

        return max==Integer.MIN_VALUE ? 0 : max;
    }
}