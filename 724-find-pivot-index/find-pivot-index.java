class Solution {
    public int pivotIndex(int[] arr) 
    {
        int n = arr.length;
        int total=0;
        for(int x : arr){
            total += x;    
        }
        int pre=0, suff=0;
        for(int i=0 ; i<n ; i++){
            suff = total-pre-arr[i];

            if(pre==suff){
                return i;
            }

            pre += arr[i];
        }

        return -1;
    }
}