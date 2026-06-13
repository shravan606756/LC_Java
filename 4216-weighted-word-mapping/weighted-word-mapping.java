class Solution {
    public String mapWordWeights(String[] words, int[] weights) 
    {
        StringBuilder sb = new StringBuilder();
        for(String x : words)
        {
            int s=0;

            for(int i=0 ; i<x.length() ; i++)
            {
                s += weights[x.charAt(i)-'a'];
            }

            int n = s%26;
            sb.append((char)('z'-n));
        }

        return sb.toString();
    }
}