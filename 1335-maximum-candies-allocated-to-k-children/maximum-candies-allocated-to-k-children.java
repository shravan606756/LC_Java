class Solution {
    public int maximumCandies(int[] candies, long k) 
    {
        Arrays.sort(candies);
        int n = candies.length;
        int low=1, high = candies[n-1], res=0;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(isValid(candies, k, guess)){
                res = guess;
                low = guess+1;
            }else{
                high = guess-1;
            }
        }

        return res;
    }

    public boolean isValid(int arr[], long k, int guess)
    {
        int n = arr.length;
        long count=0;
        for(int i=0 ; i<n ; i++)
        {
            count += arr[i]/guess;
            if(count >= k){
                return true;
            }
        }

        return false;
    }
}