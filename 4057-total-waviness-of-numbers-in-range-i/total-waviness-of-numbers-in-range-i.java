class Solution {
    public int totalWaviness(int num1, int num2) 
    {
        int res=0;

        for(int i=num1 ; i<=num2 ; i++)
        {
            res += giveWaviness(i);
        }    

        return res;
    }

    public int giveWaviness(int n)
    {
        String s = String.valueOf(n);

        int c=0;
        for(int i=1 ; i<s.length()-1 ; i++)
        {
            if((s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)) || (s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1)))
            {
                c++;
            }
        }

        return c;
    }
}