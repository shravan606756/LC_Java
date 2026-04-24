class Solution {
    public int furthestDistanceFromOrigin(String moves) 
    {
        int n = moves.length();
        int cl=0,cr=0,blank=0;

        for(int i=0 ; i<n ; i++)
        {
            char x = moves.charAt(i);

            if(x=='L')
            {
                cl++;
            }
            else if(x=='R')
            {
                cr++;
            }
            else{
                blank++;
            }
        }    

        return Math.abs(cl-cr)+blank;
    }
}