class Solution {
    public int findGCD(int[] arr) 
    {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0 ; i<n ; i++)
        {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        } 

        return getGcd(max, min);
    }

    public int getGcd(int a, int b)
    {
        while(b!=0)
        {
            int temp = a%b;
            a = b;
            b = temp;
        }

        return a;
    }
}