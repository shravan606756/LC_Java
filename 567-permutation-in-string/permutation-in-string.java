class Solution 
{
    public boolean checkInclusion(String s1, String s2) 
    {
        int n1 = s1.length();
        int n2 = s2.length();

        if(n1>n2) return false;

        Map<Character, Integer> have = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();

        for(char c : s1.toCharArray()){
            have.put(c, have.getOrDefault(c, 0)+1);
        }

        int high=0, low=0;

        for(high=0; high<s1.length() ; high++){
            need.put(s2.charAt(high), need.getOrDefault(s2.charAt(high), 0)+1);
        }

        if(isValid(need, have)){
            return true;
        }

        while(high<s2.length()){
            int count = need.get(s2.charAt(low));
            count --;

            if(count==0){
                need.remove(s2.charAt(low));
            }else{
                need.put(s2.charAt(low), count);
            }
            low++;

            need.put(s2.charAt(high), need.getOrDefault(s2.charAt(high), 0)+1);
            high++;

            if(isValid(need, have)){
                return true;
            }
        }

        return false;
    }

    public boolean isValid(Map<Character, Integer> need, Map<Character, Integer>have)
    {
        for(char key : need.keySet()){
            if(!have.containsKey(key)){
                return false;
            }

            if(need.size() != have.size()){
                return false;
            }

            if(!need.get(key).equals(have.get(key))){
                return false;
            }
        }

        return true;
    }
}