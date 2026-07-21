class Solution {
    public int maxActiveSectionsAfterTrade(String s)
    {
        int ones=0;
        int n = s.length();

        for(int i=0 ; i<n ; i++)
        {
            char c = s.charAt(i);
            if(c=='1'){
                ones++;
            }
        }    

        s = "1" + s + "1";
        n=s.length();
        int i=0;
        int ans=ones;

        while(i<n && s.charAt(i)=='1'){
            i++;
        }

        int zero1=0;
        while(i<n && s.charAt(i)=='0'){
            zero1++;
            i++;
        }

        while(i<n)
        {
            int middleOne = 0;

            while(i<n && s.charAt(i)=='1'){
                middleOne++;
                i++;
            }

            if(middleOne==0){
                break;
            }

            int zero2=0;
            while(i<n && s.charAt(i)=='0'){
                zero2++;
                i++;
            }

            if(zero2==0){
                break;
            }

            ans = Math.max(ans, zero1+ones+zero2);

            zero1=zero2;
        }

        return ans;
    }
}