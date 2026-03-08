class Solution {
    public String findDifferentBinaryString(String[] arr) {
        int n = arr.length;

        Set<String> seen = new HashSet<>();

        for(int i=0 ; i<n ; i++)
        {
            seen.add(arr[i]);
        }

        int t=1;
        for(int i=0 ; i<n ; i++)
        {
            t = t*2;
        }

        for(int i=0 ; i<t ; i++)
        {
            int x=i;
            char c [] = new char [n];

            for(int j=n-1 ; j>=0 ; j--)
            {
                if(x%2==0)
                {
                    c[j]='0';
                }else{
                    c[j] = '1';
                }

                x=x/2;
            } 

            String s = new String(c);

            if(!seen.contains(s)) return s;
        }
        return "";
    }
}