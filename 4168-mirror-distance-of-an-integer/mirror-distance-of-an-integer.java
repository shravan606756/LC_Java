class Solution {
    public int mirrorDistance(int n) 
    {
        int rev = reverse(n);
        int diff = Math.abs(n-rev);
        return diff;
    }

    public int reverse(int n)
    {
        int res=0;
        int last=0;

        while(n>0)
        {
            last=n%10;
            res=res*10+last;
            n=n/10;
        }
        return res;
    }
}