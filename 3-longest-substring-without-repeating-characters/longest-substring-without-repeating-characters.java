class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        Map<Character, Integer> freq = new HashMap<>();
        int low=0, max = Integer.MIN_VALUE;
        for(int high=0 ; high<s.length(); high ++){
            freq.put(s.charAt(high), freq.getOrDefault(s.charAt(high),0)+1);
            while(!isValid(freq)){
                int count = freq.get(s.charAt(low));
                count--;
                if(count==0) freq.remove(s.charAt(low));
                else freq.put(s.charAt(low),count);
                low++;
            }
            int len = high-low+1;
            max = Math.max(max, len);
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }

    public boolean isValid(Map<Character, Integer> map){
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int val = entry.getValue();

            if(val!=1){
                return false;
            }
        }

        return true;
    }
}