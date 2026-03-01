class Solution {
    public int minPartitions(String s) 
    {
        int max=-1;

        for(int i=0 ; i<s.length() ; i++)
        {
            char x = s.charAt(i);
            int n = x-'0';
            max = Math.max(max , n); 
        }    

        return max;
    }
}