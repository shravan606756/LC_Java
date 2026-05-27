class Solution {
    public int numberOfSpecialChars(String word) 
    {
        int n = word.length();

        int l[] = new int[26];
        int u[] = new int[26];

        Arrays.fill(l,-1);
        Arrays.fill(u,Integer.MAX_VALUE);

        for(int i=0 ; i<n ; i++)    
        {
            char x = word.charAt(i);
            if(Character.isLowerCase(x))
            {
                l[x-'a']=i;
            }
            else
            {
                u[x-'A'] = Math.min(u[x-'A'],i);
            }
        }

        int c=0;

        for(int i=0 ; i<26 ; i++)
        {
            if(l[i]!=-1 && u[i]!=Integer.MAX_VALUE && l[i]<u[i])
            {
                c++;
            }
        }

        return c;
    }
}