class Solution {
    public int shipWithinDays(int[] weights, int k) {
        int n = weights.length;

        int low = 0;
        int high = 0;

        for(int x : weights){
            high += x;
        }

        int res=-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            int days = solve(weights, k, mid);

            if(days>k){
                low = mid+1;
            }else{
                res = mid;
                high = mid-1;
            }
        }

        return res;
    }

    public int solve(int arr[], int k, int guess)
    {
        int sum=0, d=1;

        for(int x : arr){
            if(x>guess){
                return k+1;
            }
            
            if(sum+x <= guess){
                sum+=x;
            }else{
                sum = x;
                d++;
            }
        }

        return d;
    }
}