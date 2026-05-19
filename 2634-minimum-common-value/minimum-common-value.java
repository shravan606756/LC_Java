class Solution {
    public int getCommon(int[] arr1, int[] arr2) 
    {
        int i=0,j=0;

        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]==arr2[j])
            {
                return arr1[i];
            }
            else if(arr1[i]>arr2[j])
            {
                j++;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}