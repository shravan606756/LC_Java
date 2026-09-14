class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1X1 = rec1[0], rec1Y1 = rec1[1], rec1X2 = rec1[2], rec1Y2 = rec1[3];
        int rec2X1 = rec2[0], rec2Y1 = rec2[1], rec2X2 = rec2[2], rec2Y2 = rec2[3];

        int commonWidth = Math.min(rec1X2, rec2X2) - Math.max(rec1X1, rec2X1);
        int commonLength =Math.min(rec1Y2, rec2Y2) - Math.max(rec1Y1, rec2Y1);

        //int commonArea = commonWidth*commonLength;
        return commonWidth>0 && commonLength>0 ? true : false;
    }
}