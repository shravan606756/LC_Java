class Solution {
    public int rearrangeCharacters(String s, String t)
    {
       Map<Character, Integer> sMap = new HashMap<>();
       Map<Character, Integer> tMap = new HashMap<>();

       for(char c : s.toCharArray())
       {
            sMap.put(c, sMap.getOrDefault(c, 0)+1);
       } 

       for(char c : t.toCharArray())
       {
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
       }

        int res = Integer.MAX_VALUE;

       for(char c : tMap.keySet())
       {
            int available = sMap.getOrDefault(c, 0);
            int need = tMap.get(c);

            res = Math.min(res, available/need);
       }

       return res == Integer.MAX_VALUE ? 0 : res;
    }
}