class Solution {
    public int minDays(int[] doomDay, int m, int k) 
    {
        int max = -1, res = -1;
        for(int x : doomDay){
            max = Math.max(max, x);
        }       

        int low=1, high=max;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(isDoomsDay(doomDay, k, m, guess)){
                res = guess;
                high = guess-1;
            }else{
                low = guess+1;
            }
        }

        return res;
    }

    public boolean isDoomsDay(int arr[], int k, int m, int guess)
    {
        /*
            we want m boq
            with k cons flowers
            ith flower grows after arr[i] days
        */

        int n = arr.length;
        int consecutiveCount = 0, boq=0;
        for(int i=0 ; i<n ; i++){
            if(arr[i]<=guess){
                consecutiveCount++;
            }else{
                consecutiveCount=0;
            }

            if(consecutiveCount==k){
                boq++;
                consecutiveCount=0;
            }
        }

        return boq>=m;
    }
}