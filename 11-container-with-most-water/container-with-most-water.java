class Solution {
    public int maxArea(int[] height) 
    {
        int n = height.length;

        int i=0,j=n-1;
        int res=0;

        while(i<j)
        {
            int cap = Math.min(height[i],height[j]);
            int width = j-i;
            res = Math.max(res, cap*width);

            if(height[i]>height[j])
            {
                j--;
            }
            else{
                i++;
            }
        }

        return res;   
    }
}