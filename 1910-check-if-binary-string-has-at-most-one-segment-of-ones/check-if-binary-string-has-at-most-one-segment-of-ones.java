class Solution {
    public boolean checkOnesSegment(String s) 
    {
        char c = s.charAt(0);
        if(c=='0')
        {
            return false;
        }
        int count = 0; 
        for(int i=1 ; i<s.length() ; i++)
        {
            char x = s.charAt(i);

            if(x=='0')
            {
                count=1;
            }
            if(count==1 && x=='1')
            {
                return false;
            }
        }        

        return true;
    }
}