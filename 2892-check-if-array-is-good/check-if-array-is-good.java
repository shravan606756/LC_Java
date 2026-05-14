class Solution {
    public boolean isGood(int[] arr) 
    {
        int n = arr.length;

        java.util.Arrays.sort(arr);

        boolean firstCheck = true;

        for(int i = 0; i < n-1; i++)
        {
            if(arr[i] != i+1)
            {
                firstCheck = false;
            }
        }

        boolean secondCheck = false;

        if(arr[n-1] == n-1)
        {
            secondCheck = true;
        }

        if(firstCheck == true && secondCheck == true)
        {
            return true;
        }

        return false;
    }
}