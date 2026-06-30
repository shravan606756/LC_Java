class Solution {
    public int numberOfSubstrings(String s)
    {
        Map<Character, Integer> freq = new HashMap<>();
        int low=0, ans=0;
        for(int high=0 ; high<s.length(); high++)
        {
            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high), 0)+1);

            while(freq.size()==3){
                ans += s.length()-high;
                char d = s.charAt(low);
                int count = freq.get(d);
                count--;
                if(count==0)freq.remove(d);
                else freq.put(d, count);
                low++;
            }
        }

        return ans;
    }
}