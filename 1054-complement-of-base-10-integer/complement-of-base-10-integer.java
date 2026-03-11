class Solution {
    public int bitwiseComplement(int n) 
    {
        String bin = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<bin.length() ; i++)
        {
            char x = bin.charAt(i);
            if(x=='1')
            {
                sb.append("0");
            }
            else{
                sb.append("1");
            }            
        }    

        String res = sb.toString();
        return Integer.parseInt(res,2);
    }
}