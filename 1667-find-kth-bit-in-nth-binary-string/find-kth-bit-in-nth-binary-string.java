class Solution {
    public char findKthBit(int n, int k) 
    {
        String ans = "0";
        
        while(n>1)
        {
            String temp = ans;
            String inv = invert(temp);
            String rev = new StringBuilder(inv).reverse().toString();
            ans = ans + "1" + rev;
            n--;
        }

        return ans.charAt(k-1);
    }

    public String invert(String s)
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<s.length() ; i++)
        {
            if(s.charAt(i)=='1')
            {
                sb.append("0");
            }else{
                sb.append("1");
            }
        }

        return sb.toString();
    }
}