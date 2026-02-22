class Solution {
    public int binaryGap(int n) 
    {
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