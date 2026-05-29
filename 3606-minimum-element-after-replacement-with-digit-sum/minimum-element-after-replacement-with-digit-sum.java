class Solution {
    public int minElement(int[] arr) 
    {
        int n = arr.length;

        //n -> sum=n.1+n.2+...
        int min = Integer.MAX_VALUE;
        for(int x : arr)
        {
            String s = String.valueOf(x);
            int z=0;
            for(int i=0 ; i<s.length() ; i++)
            {
                z += (s.charAt(i)-'0')%10;
            }
            min = Math.min(min , z);
        }   

        return min; 
    }
}