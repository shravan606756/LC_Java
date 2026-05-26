class Solution {
    public int numberOfSpecialChars(String word) 
    {
        Set<Character> lower = new HashSet<>();
        Set<Character> upper = new HashSet<>();

        for(int i=0 ; i<word.length() ; i++)
        {
            char x = word.charAt(i);

            if(Character.isLowerCase(x))
            {
                lower.add(x);
            }

            else
            {
                upper.add(Character.toLowerCase(x));
            }
        }    

        int c=0;
        for(char ch : lower)
        {
            if(upper.contains(ch))
            {
                c++;
            }
        }

        return c;
    }
}