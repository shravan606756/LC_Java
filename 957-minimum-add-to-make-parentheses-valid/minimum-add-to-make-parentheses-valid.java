class Solution {
    int n;

    public int minAddToMakeValid(String s) {
        n = s.length();
        int res = solve(s);

        return res;
    }

    public int solve(String s)
    {
        int count=0, extra=0;

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);
            if(c=='('){
                count++;
            }else{
                count--;
                if(count<0){
                    extra++;
                    count=0;
                }
            }
        }

        return extra+count;
    }
}