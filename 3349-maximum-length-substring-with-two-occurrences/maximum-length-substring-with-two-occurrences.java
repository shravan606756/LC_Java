class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int low=0;
        for(int high=0 ; high<n ; high++)
        {
            char c = s.charAt(high);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.get(s.charAt(high))>2){
                int count = map.get(s.charAt(low));
                count--;

                if(count==0){
                    map.remove(s.charAt(low));
                }else{
                    map.put(s.charAt(low), count);
                }

                low++;
            }

            int len = high-low+1;
            max = Math.max(max, len);
        }

        return max==Integer.MIN_VALUE ? -1 : max;
    }
}