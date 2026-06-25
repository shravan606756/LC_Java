class Solution {
    public int countMajoritySubarrays(int[] arr, int target) 
    {
        int n= arr.length;

        int res=0;

        for(int i=0 ; i<n ; i++)
        {
            int c=0;
            for(int j=i ; j<n ; j++){
                int len = j-i+1;
                if(arr[j]==target){
                    c++;
                }

                if(c>len/2){
                    res++;
                }
            }
        }

        return res;
    }
}