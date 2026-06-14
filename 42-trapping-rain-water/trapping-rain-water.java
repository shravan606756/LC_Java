class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;
        int rightMax[] = getRightMax(height);
        int leftMax[] =  getLeftMax(height);
        
        int total=0;
        for(int i=0 ; i<n ; i++)
        {
            int h = Math.min(rightMax[i], leftMax[i]);
            int w = h-height[i];

            total+=w;
        }

        return total;
    }

    public int [] getRightMax(int height[])
    {
        int rightMax[] = new int [height.length];
        rightMax[height.length-1] = height[height.length-1];

        for(int i=height.length-2 ; i>=0 ; i--)
        {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        return rightMax;
    }

    public int [] getLeftMax(int height[])
    {
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for(int i=1 ; i<height.length ; i++)
        {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        return leftMax;
    }
}