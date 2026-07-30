class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) 
    {
        int r1 = startPos[0];
        int c1 = startPos[1];

        int r2 = homePos[0];
        int c2 = homePos[1];

        int cost=0;

        if(r2 > r1){
            for(int r = r1 + 1; r <= r2; r++){
                cost += rowCosts[r];
            }
        }else{
            for(int r = r1 - 1; r >= r2; r--){
                cost += rowCosts[r];
            }
        }

        if(c2>=c1){
            for(int c=c1+1 ; c<=c2 ; c++){
                cost+=colCosts[c];
            }
        }else{
            for(int c=c1-1 ; c>=c2 ; c--){
                cost += colCosts[c]; 
            }
        }

        return cost;
    }
}