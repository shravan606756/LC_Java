class Solution {
    public char findKthBit(int n, int k) 
    {
        int flipcount = 0;

        while(n>1)
        {
            int length = (int) Math.pow(2,n)-1;
            int mid = (length/2)+1;

            if(k==mid)
            {
                if(flipcount%2==0)
                {
                    return '1';
                }else{
                    return '0';
                }
            }

            else if(k>mid)
            {
                k = length-k+1;
                flipcount = flipcount +1;
            }

            n=n-1;
        }

        if(flipcount%2==0)
        {
            return '0';
        }else{
            return '1';
        }
    }
}