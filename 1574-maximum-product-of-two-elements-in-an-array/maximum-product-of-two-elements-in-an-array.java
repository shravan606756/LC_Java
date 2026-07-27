class Solution {
    public int maxProduct(int[] arr) 
    {
        int max1=-1, max2=-1;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE; 

        for(int x : arr)
        {
            if(x>=max1){
                max2 = max1;
                max1 = x;
            } else if(x>max2) max2 = x;
        }   

        for(int x : arr){
            if(x<=min1){
                min2 = min1;
                min1 = x;
            }
            else if(x<min2) min2 = x;
        }

        return Math.max((max1-1)*(max2-1), (min1-1)*(min2-1));
    }
}