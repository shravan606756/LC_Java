class Solution {
    public int maxArea(int[] height) 
    {
        int n = height.length;
        int res = Integer.MIN_VALUE;
        int l=0, r = n-1;

        while(l<r)
        {
            int cap = Math.min(height[l], height[r]);
            int width = r-l;

            res = Math.max(res, cap*width);

            if(height[r]<height[l]){
                r--;
            }else{
                l++;
            }
        }

        return res;
    }
}