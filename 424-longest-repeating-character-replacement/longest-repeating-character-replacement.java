class Solution {
    public int characterReplacement(String s, int k) 
    {
        Map<Character, Integer> freq = new HashMap<>();
        int low = 0, max = Integer.MIN_VALUE;
        int maxCount = 0 ;
        for(int high=0 ; high<s.length() ; high++)
        {
            char c = s.charAt(high);
            freq.put(c, freq.getOrDefault(c, 0)+1);
            maxCount = Math.max(maxCount, freq.get(c));
            int diff = (high-low+1) - maxCount;

            if(diff>k)
            {
                int count = freq.get(s.charAt(low));
                count--;
                if(count==0){
                    freq.remove(s.charAt(low));
                }
                else{
                    freq.put(s.charAt(low), count);
                }

                low++;
            }

            if(diff<=k){
                int len = high-low+1;
                max = Math.max(max, len);
            }
        }

        return max==Integer.MIN_VALUE ? 0 : max;
    }
}