class Solution {
    public int maxDistance(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int max = 0;
        int i=0 , j=0;

        while(i<n1 && j<n2)
        {
            if(arr1[i]>arr2[j])
            {
                i++;
            }

            else 
            {
                max = Math.max(max , j-i);
                j++;
            }
        }   

       

        return max;             
    }
}