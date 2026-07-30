class Solution {
    public int minimumPushes(String word)
    {
        int res=0;
        int n = word.length();

        if(n<=8) res = n;
        else if(n<=16) res = 8 + (n-8)*2;
        else if(n<=24) res = 24 + (n-16)*3;
        else res = 48 + (n-24)*4;

        return res;
    }
}