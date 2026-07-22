class Solution {
    public int minFlips(String s)
    {
        int n = s.length();
        s = s+s;
        int min = Integer.MAX_VALUE;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            s1.append(i % 2 == 0 ? '1' : '0');
            s2.append(i % 2 == 0 ? '0' : '1');
        }

        int low=0, flip1=0, flip2=0;
        for(int high=0 ; high<2*n ; high++)
        {
            if(s.charAt(high)!=s1.charAt(high)){
                flip1++;
            }if(s.charAt(high)!=s2.charAt(high)){
                flip2++;
            }

            while(high-low+1 > n){
                if(s.charAt(low)!=s1.charAt(low)){
                    flip1--;
                }if(s.charAt(low)!=s2.charAt(low)){
                    flip2--;
                }
                low++;
            }

            if(high-low+1==n){
                min = Math.min(min, Math.min(flip1, flip2));
            }
        }       

        return min==Integer.MAX_VALUE ? 0 : min;
    }
}