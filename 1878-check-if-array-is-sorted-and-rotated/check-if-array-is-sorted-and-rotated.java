class Solution {
    public boolean check(int[] arr) 
    {
        int n = arr.length;
        if(n==1) return true;
        int count=0;

        for(int i=1 ; i<n*2 ; i++)
        {
            if(arr[i%n]>=arr[(i-1)%n])
            {
                count++;
            }
            else{
                count=1;
            }

            if(count==n)
            {
                return true;
            }
        }

        return false;
    }
}