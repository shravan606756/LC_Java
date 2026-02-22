class Solution {
    public int binaryGap(int n) 
    {
        /*
            VERY FIRST INTUTION : 
            *convert to binary string first
            *keep a track of current seen index of "1" & prev seen "1"
            * return max distance
         */
        String bin = Integer.toBinaryString(n);
        int max = 0;
        int prev = -1;
        for(int i=0 ; i<bin.length() ; i++)
        {
            char x = bin.charAt(i);
            if(x == '1')
            {
                if(prev!=-1)
                {
                    max = Math.max(max , i-prev);
                }

                prev=i;
            }
        }

        return max;
    }
}