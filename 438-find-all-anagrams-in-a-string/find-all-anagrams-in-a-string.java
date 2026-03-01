class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
    {
        int n1 = s.length();
        int n2 = p.length();

        List<Integer> res = new ArrayList<>();
        Map<Character , Integer> have = new HashMap<>();
        Map<Character , Integer> need = new HashMap<>();

        for(int i=0 ; i<n2 ; i++)
        {
            char x = p.charAt(i);
            need.put(x , need.getOrDefault(x,0)+1);
        }
        int l=0;
        for(int h=0 ; h<n1 ; h++)
        {
            char x = s.charAt(h);
            have.put(x , have.getOrDefault(x,0)+1);

            while(h-l+1 > n2)
            {
                char d = s.charAt(l);
                int f = have.get(d);
                have.put(d , f-1);

                if(have.get(d)==0)
                {
                    have.remove(d);
                }
                l++;
            }

            if(h-l+1==n2 && isValid(have , need))
            {
                res.add(l);
            }
        }

        return res;
    }

    public boolean isValid( Map<Character , Integer> have ,  Map<Character , Integer> need)
    {
        if(have.size()!=need.size())
        {
            return false;
        }

        for(char c : need.keySet())
        {
            if(!have.containsKey(c))
            {
                return false;
            }

            if(! have.get(c).equals(need.get(c)))
            {
                return false;
            }
        }
        return true;
    }
}