class Solution {
    public int maxVowels(String s, int k) 
    {
        int n = s.length();
        int l=0 , h=k-1;
        int c=0;
        for(int i=0 ; i<=h ; i++)
        {
            char x = s.charAt(i);
            if(isVowel(x))
            {
                c++;
            }
        }

        int max=c;

        while(h<n-1)
        {
            if(isVowel(s.charAt(l)))
            {
                c--;
            }
            l++;

            h++;
            if(isVowel(s.charAt(h)))
            {
                c++;
            }

            max = Math.max(max , c);
        }

        return max;
    }

    public boolean isVowel(char x)
    {
        if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u')
        {
            return true;
        }
        return false;
    }
}