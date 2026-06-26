class Solution {
    public List<Integer> findAnagrams(String s, String p) 
    {
        HashMap<Character, Integer> have  = new HashMap<>();
        HashMap<Character, Integer> need  = new HashMap<>();
        
        List<Integer> res = new ArrayList<>();

        for(char x : p.toCharArray())
        {
            need.put(x, need.getOrDefault(x, 0)+1);
        }
        int low=0;
        for(int high=0 ; high<s.length() ; high++)
        {
            have.put(s.charAt(high), have.getOrDefault(s.charAt(high), 0)+1);

            while(high-low+1>p.length())
            {
                char d = s.charAt(low);
                int count = have.get(d);
                count--;

                if(count==0)
                {
                    have.remove(d);
                }

                else{
                    have.put(d, count);
                }

                low++;
            }
            
            if(high-low+1==p.length() && isValid(have, need)) res.add(low);
        }

        return res;
    }

    public boolean isValid(HashMap<Character, Integer> have, HashMap<Character, Integer> need)
    {
        if(have.size()!=need.size()){
                return false;
        }

        for(char c : need.keySet())
        {
            if(!have.containsKey(c))
            {
                return false;
            }

            if(!have.get(c).equals(need.get(c)))
            {
                return false;
            }
        }

        return true;
    }
}