class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX=0;
        int nearestY=0;

        //for nearest x
        if(xCenter<x1){
            nearestX = x1;
        }else if(xCenter>x2){
            nearestX = x2;
        }else{
            nearestX = xCenter;
        }

        //for nearest 
        if(yCenter<y1){
            nearestY = y1;
        }else if(yCenter>y2){
            nearestY = y2;
        }else{
            nearestY = yCenter;
        }

        //euclidean
        int distance = (int) Math.sqrt(((nearestX - xCenter) * (nearestX - xCenter)) + ((nearestY - yCenter) * (nearestY - yCenter)));

        return radius>=distance;
    }
}