class Solution {
    public int hIndex(int[] arr) 
    {
        int n=arr.length;
        int low=0, high=n;
        int res = -1;

        while(low<=high){
            int guess = low + (high-low)/2;

            if(isValid(arr, guess)){
                res = guess;
                low = guess+1;
            }else{
                high = guess-1;
            }
        }    

        return res;
    }

    public boolean isValid(int arr[], int guess)
    {
        int n = arr.length;
        int paper=0;
        
        for(int i=0 ; i<n ; i++)
        {
            if(arr[i]>=guess){
                paper++;
            }
        }

        return paper>=guess;
    }
}