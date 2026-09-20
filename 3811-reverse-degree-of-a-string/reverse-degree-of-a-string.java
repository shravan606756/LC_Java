class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum=0;

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);
            int num = ('z'-c+1) * (i+1); //c-'a'+1
            sum+=num;
        }

        return sum;
    }
}